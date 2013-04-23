package vn.edu.rmit.sadi;

import java.rmi.RemoteException;

public interface CallBackRemote {

    public void joinedMessage(String from) throws RemoteException;

    public void quitMessage(String from) throws RemoteException;

    public void addMessage(String from, String message) throws RemoteException;

}
