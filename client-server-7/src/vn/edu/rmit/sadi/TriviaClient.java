package vn.edu.rmit.sadi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TriviaClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4415);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream(), true);

            String msgFromServer;
            Scanner sc = new Scanner(System.in);

            while ((msgFromServer = in.readLine()) != null) {
                System.out.println("Server: " + msgFromServer);
                out.println(sc.nextLine());
            }

            out.close();
            in.close();
            socket.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
