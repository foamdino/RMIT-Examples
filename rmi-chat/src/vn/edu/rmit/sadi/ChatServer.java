package vn.edu.rmit.sadi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ChatServer extends UnicastRemoteObject implements ChatServerRemote {

    public static final int RMIREGISTRY_PORT = 1099;
    public static final String REMOTE_OBJECT_URL = "rmi://localhost:1099/ChatServer";

    private final HashMap<String, CallBackRemote> callbacks = new HashMap<String, CallBackRemote>();

    public ChatServer() throws RemoteException {}

    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(RMIREGISTRY_PORT);
            ChatServer srvr = new ChatServer();
            Naming.rebind(REMOTE_OBJECT_URL, srvr);
            System.out.println("ChatServer is running...");
        } catch (Exception e) {
            System.err.println("Error running ChatServer:");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Status connect(String userName, CallBackRemote callback) throws RemoteException {
        if (userName == null || userName.equals("") || userName.equals("ChatServer")
                || callback == null) {
            return Status.UsernameInvalid;
        }
        synchronized (callbacks) {
            if (callbacks.containsKey(userName)) {
                return Status.UserExists;
            }
            callbacks.put(userName, callback);
        }

        try {
            callback.addMessage("ChatServer", "Welcome " + userName);

            HashMap<String, CallBackRemote> h;
            synchronized (callbacks) {
                h = (HashMap<String, CallBackRemote>) callbacks.clone();
            }
            for (CallBackRemote c : h.values()) {
                c.joinedMessage(userName);
            }

            return Status.Success;
        } catch (RemoteException ex) {
            System.err.println("Error from callback " + ex.getMessage());
        }

        return Status.Error;
    }

    @Override
    public void disconnect(String userName) throws RemoteException {
        HashMap<String, CallBackRemote> h;
        synchronized (callbacks) {
            if (callbacks.remove(userName) == null) {
                // user did not exist
                return;
            }
            h = (HashMap<String, CallBackRemote>) callbacks.clone();
        }
        for (CallBackRemote callback : h.values()) {
            callback.quitMessage(userName);
        }
    }

    @Override
    public void sendChatMessage(String userName, String message) throws RemoteException {
        if (userName == null || userName.equals("")
                || message == null || message.equals("")) {
            return;
        }
        HashMap<String, CallBackRemote> h;
        synchronized (callbacks) {
            if (!callbacks.containsKey(userName)) {
                return;
            }
            h = (HashMap<String, CallBackRemote>) callbacks.clone();
        }
        try {
            for (CallBackRemote callback : h.values()) {
                callback.addMessage(userName, message);
            }
        } catch (Exception e) {
            System.err.println("Error from callback " + e.getMessage());
        }
    }
}
