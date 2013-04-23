package vn.edu.rmit.sadi;

import java.rmi.RemoteException;

public interface ChatServerRemote {

    public Status connect(String userName, CallBackRemote callback) throws RemoteException;

    public void disconnect(String userName) throws RemoteException;

    public void sendChatMessage(String userName, String message) throws RemoteException;

    public enum Status {
        Error, UsernameInvalid, UserExists, Success
    }
}
