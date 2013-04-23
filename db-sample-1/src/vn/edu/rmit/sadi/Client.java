package vn.edu.rmit.sadi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Simple client code to interact with the server
 */
public class Client extends JFrame {

    final private Log log = LogFactory.getLog(Client.class);

    private static ApplicationContext ctx;
    private int port;

    public static void main(String[] args) {
        ctx = new ClassPathXmlApplicationContext("client-context.xml");
        Client c = ctx.getBean("client", Client.class);
        c.run();
    }

    private void run() {
        try {
            createUI();
        } catch (Exception e) {
            log.error(e);
        }
    }

    private void createUI() throws Exception {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        setTitle("Messages");
        final JTextArea messages = new JTextArea();
        messages.setEditable(false);
        panel.add(new JScrollPane(messages));
        final JTextField msg = new JTextField();
        panel.add(msg);
        JButton send = new JButton("Send");
        panel.add(send);
        final Socket socket = new Socket("localhost", port);
        final DataInputStream dis = new DataInputStream(socket.getInputStream());
        final DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dos.writeUTF(msg.getText());
                    dos.flush();
                    // clear message
                    msg.setText("");
                    messages.setText(dis.readUTF());

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(panel);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setPort(int port) {
        this.port = port;
    }
}
