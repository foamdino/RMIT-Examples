package vn.edu.rmit.sadi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Communicator {

    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public Communicator(Socket socket, ObjectInputStream ois, ObjectOutputStream oos) {
        this.socket = socket;
        this.ois = ois;
        this.oos = oos;
    }

    public void write(Object obj) {
        try {
            oos.writeObject(obj);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Object read() {
        try {
            return ois.readObject();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
