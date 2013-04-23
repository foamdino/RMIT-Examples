package vn.edu.rmit.sadi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * A simple web client
 */
public class Main {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.google.com", 80);
            try {
                PrintStream output = new PrintStream(s.getOutputStream());
                output.print("GET / HTTP/1.0\n\n");
                output.flush();

                Scanner in = new Scanner(s.getInputStream());
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
