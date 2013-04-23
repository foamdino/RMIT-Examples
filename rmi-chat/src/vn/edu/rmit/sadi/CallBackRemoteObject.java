package vn.edu.rmit.sadi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observer;

public class CallBackRemoteObject extends UnicastRemoteObject implements CallBackRemote {

    private Observer ui;

    // inject observer in constructor
    public CallBackRemoteObject(Observer ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public void joinedMessage(String from) throws RemoteException {
        ui.update(null, from + " has joined.");
    }

    @Override
    public void quitMessage(String from) throws RemoteException {
        ui.update(null, from + " has left.");
    }

    @Override
    public void addMessage(String from, String message) throws RemoteException {
        ui.update(null, '<' + from + "> " + message);
    }
}
