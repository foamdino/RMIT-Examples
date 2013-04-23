package vn.edu.rmit.sadi;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 10013);
            try {
                InputStream inStream = s.getInputStream();
                Scanner in = new Scanner(inStream);
                while (in.hasNextLine()) {
                    System.out.println(in.nextLine());
                }
            } finally {
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
