package vn.edu.rmit.sadi;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class InquiryServer extends JFrame {

    private static final Map<String, Integer> productPrices = new HashMap<>();

    static {
        productPrices.put("iPhone", 600);
        productPrices.put("iPad", 500);
        productPrices.put("HTC Desire HD", 700);
        productPrices.put("Galaxy Pad", 700);
        productPrices.put("Galaxy S3", 700);
    }

    public static void main(String[] args) {
        InquiryServer server = new InquiryServer();
        server.setVisible(true);
        server.setSize(600, 400);
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        server.run();
    }

    public void run() {
        try {
            JTextArea area = new JTextArea();
            area.setEditable(false);
            this.add(new JScrollPane(area));
            ServerSocket server = new ServerSocket(19999);
            area.append("Start listening...\n");
            Socket client = server.accept();
            area.append("Client connection established!\n");
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

}
