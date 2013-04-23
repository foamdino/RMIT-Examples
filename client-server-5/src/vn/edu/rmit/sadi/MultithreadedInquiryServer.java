package vn.edu.rmit.sadi;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Demonstration of using multiple threads to handle many clients
 */
public class MultithreadedInquiryServer extends JFrame {
    public static void main(String[] args) throws IOException {
        MultithreadedInquiryServer server = new MultithreadedInquiryServer();
        server.setVisible(true);
        server.setSize(600, 400);
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        server.run();
    }
    private static final Map<String, Integer> productPrices = new HashMap<String, Integer>();


    static {
        productPrices.put("iPhone", 600);
        productPrices.put("iPad", 500);
        productPrices.put("HTC Desire HD", 700);
        productPrices.put("Galaxy Pad", 700);
    }

    public void run() throws IOException {
        try {
            final JTextArea area = new JTextArea();
            area.setEditable(false);
            this.add(new JScrollPane(area));
            ServerSocket server = new ServerSocket(19999);
            area.append("Start listening...\n");
            while (true) {
                final Socket client = server.accept();
                area.append("Client connection established!\n");
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            DataInputStream dis = new DataInputStream(client.getInputStream());
                            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                            String productName = dis.readUTF();
                            while (!productName.equals("Quit")) {
                                int quantity = dis.readInt();
                                area.append("Receive quote request for " + productName + ":" + quantity + "\n");
                                if (productPrices.containsKey(productName)) {
                                    int price = productPrices.get(productName);
                                    int total = price * quantity;
                                    if (total > 1000) {
                                        total = (int) ((double) total * 90 / 100);
                                    }
                                    dos.writeUTF("Total price " + total);
                                } else {
                                    dos.writeUTF("Warning: Specified product not exist");
                                }
                                productName = dis.readUTF();
                            }
                            area.append("Closing client connection...\n");
                            client.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(MultithreadedInquiryServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}