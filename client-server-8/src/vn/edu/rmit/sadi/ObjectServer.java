package vn.edu.rmit.sadi;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9999);
            Socket client = server.accept();
            InputStream is = client.getInputStream();
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(is);
                Person savedJohn = (Person)ois.readObject();
                System.out.println(savedJohn);
                System.out.println(savedJohn.getFriend());
                System.out.println(savedJohn.getFriend().getFriend());
            } finally {
                if (ois != null) {
                    ois.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
