package vn.edu.rmit.sadi;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame implements Runnable{

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.setTitle("TicTacToe Server");
            server.setVisible(true);
            server.setSize(600, 400);
            server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            new Thread(server).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            final JTextArea area = new JTextArea();
            area.setEditable(false);
            add(new JScrollPane(area));
            ServerSocket server = new ServerSocket(9999);
            while (true) {
                area.append("Waiting to set up a new session...\n");
                GameHandler handler = new GameHandler();
                for (int i = 0; i < 2; i++) {
                    Socket socket = server.accept();
                    area.append("Player " + i + " connected...\n");
                    Communicator communicator = new Communicator(socket,
                            new ObjectInputStream(socket.getInputStream()),
                            new ObjectOutputStream(socket.getOutputStream()));
                    communicator.write(i == 0 ?
                            Player.Player1 : Player.Player2);
                    handler.add(communicator);
                }
                new Thread(handler).start();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
