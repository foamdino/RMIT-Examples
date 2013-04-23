package vn.edu.rmit.sadi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(10013);

            while(true) {
                Socket socket = serverSocket.accept();
                PrintStream output = new PrintStream(socket.getOutputStream());
                output.print(new Date().toString());
                output.print("Bye Bye");
                socket.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
