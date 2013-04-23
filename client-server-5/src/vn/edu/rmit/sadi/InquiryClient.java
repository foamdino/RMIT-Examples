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
            JPanel pnlCommands = new JPanel();
            pnlCommands.setLayout(new GridLayout(3, 2));

            pnlCommands.add(new JLabel("Product name: "));
            final JTextField txtProduct = new JTextField();
            pnlCommands.add(txtProduct);

            pnlCommands.add(new JLabel("Quantity: "));
            final JTextField txtQuantity = new JTextField();
            pnlCommands.add(txtQuantity);

            JButton btnSubmit = new JButton("Submit");
            pnlCommands.add(btnSubmit);

            JButton btnClose = new JButton("Close");
            pnlCommands.add(btnClose);

            add(pnlCommands, BorderLayout.NORTH);
            final JTextArea area = new JTextArea();
            add(new JScrollPane(area));
            final Socket socket = new Socket("localhost", 19999);
            final DataInputStream dis = new DataInputStream(socket.getInputStream());
            final DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            btnSubmit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String productName = txtProduct.getText();
                        int quantity = Integer.parseInt(txtQuantity.getText());
                        area.append("Query price for " + productName + ":" + quantity + "\n");
                        dos.writeUTF(productName);
                        dos.writeInt(quantity);
                        area.append(dis.readUTF() + "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            btnClose.addActionListener(new ActionListener() {
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
