package vn.edu.rmit.sadi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class InquiryClient extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new InquiryClient();
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public InquiryClient() {
        try {
            JPanel commands = new JPanel();
            commands.setLayout(new GridLayout(3, 2));

            commands.add(new JLabel("Product name: "));
            final JTextField txtProduct = new JTextField();
            commands.add(txtProduct);

            commands.add(new JLabel("Quantity: "));
            final JTextField quantity = new JTextField();
            commands.add(quantity);

            JButton submit = new JButton("Submit");
            commands.add(submit);

            JButton close = new JButton("Close");
            commands.add(close);

            add(commands, BorderLayout.NORTH);
            final JTextArea area = new JTextArea();
            add(new JScrollPane(area));
            final Socket socket = new Socket("localhost", 19999);
            final DataInputStream dis = new DataInputStream(socket.getInputStream());
            final DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            submit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String productName = txtProduct.getText();
                        int qty = Integer.parseInt(quantity.getText());
                        area.append("Query price for " + productName + ":" + qty + "\n");
                        dos.writeUTF(productName);
                        dos.writeInt(qty);
                        area.append(dis.readUTF() + "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        dos.writeUTF("Quit");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}