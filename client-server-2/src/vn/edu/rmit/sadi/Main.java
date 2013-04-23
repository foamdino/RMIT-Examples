package vn.edu.rmit.sadi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.google.com", 80);
            try {
                InetAddress remote = s.getInetAddress();
                System.out.println("Remote host " + remote.getHostName());
                System.out.println("Remote IP " + remote.getHostAddress());
                System.out.println("Remote port " + s.getPort());

                InetAddress local = s.getLocalAddress();
                System.out.println("Local host " + local.getHostName());
                System.out.println("Local IP " + local.getHostAddress());
                System.out.println("Local port " + s.getLocalPort());
            } finally {
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
