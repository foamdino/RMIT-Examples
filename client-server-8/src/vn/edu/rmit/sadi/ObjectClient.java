package vn.edu.rmit.sadi;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ObjectClient {

    private static Person createTestPerson() {
        Person john = new Person("John", "john1234", 25);
        Person jane = new Person("Jane", "jane1234", 27);
        john.setFriend(jane);
        jane.setFriend(john);
        return john;
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);
            ObjectOutputStream oos = null;
            try {
                OutputStream os = socket.getOutputStream();
                oos = new ObjectOutputStream(os);
                Person john = createTestPerson();
                oos.writeObject(john);
            } finally {
                if (oos != null) {
                    oos.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
