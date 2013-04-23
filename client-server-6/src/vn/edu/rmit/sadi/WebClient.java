package vn.edu.rmit.sadi;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WebClient {

    public static void main(String[] args) {
	    try {
            Socket socket = new Socket("localhost", 8771);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()), true);
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Please enter URL: ");
                writer.println("GET " + scanner.nextLine());
                writer.flush();
                String line;
                while (!(line = reader.readLine()).equals("END"))
                    System.out.println(line);
            }
        } catch(Exception e) {

        }
    }
}
