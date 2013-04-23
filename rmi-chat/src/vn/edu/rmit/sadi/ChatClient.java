package vn.edu.rmit.sadi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.Naming;
import java.util.Observable;
import java.util.Observer;

public class ChatClient extends JFrame implements Observer, ActionListener {

    private ChatServerRemote chatServer; // reference to the remote chat server

    private JTextArea txtDisplay = new JTextArea(10, 10);
    private JTextField txtMessage = new JTextField(40);
    private JButton btnSend = new JButton("Send");
    private JButton btnLeave = new JButton("Leave");
    private String userName;

    public ChatClient() {
        super("ChatClient");

        txtDisplay.setEditable(false);
        txtDisplay.setLineWrap(true);
        txtDisplay.setWrapStyleWord(true);
        add(new JScrollPane(txtDisplay));

        JPanel buttonsPanel = new JPanel(new GridLayout());
        buttonsPanel.add(btnSend);
        buttonsPanel.add(btnLeave);
        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(txtMessage);
        controlPanel.add(buttonsPanel, BorderLayout.EAST);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

        txtMessage.addActionListener(this);
        btnSend.addActionListener(this);
        btnLeave.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                quit();
            }
            public void windowOpened(WindowEvent e) {
                connect();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnSend || src == txtMessage) {
            sendMessage();
        } else if (src == btnLeave) {
            quit();
        }
    }

    private void connect() {
        try {
            chatServer = (ChatServerRemote) Naming.lookup(ChatServer.REMOTE_OBJECT_URL);
            CallBackRemoteObject callback = new CallBackRemoteObject(this);
            ChatServerRemote.Status status;
            do {
                userName = JOptionPane.showInputDialog(this, "Enter your username",
                        "ChatClient", JOptionPane.QUESTION_MESSAGE);
                if (userName == null || userName.equals("")) {
                    quit();
                }
                status = chatServer.connect(userName, callback);
                if (status != ChatServerRemote.Status.Success) {
                    JOptionPane.showMessageDialog(this, "Username is invalid or in use",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (status != ChatServerRemote.Status.Success);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Connection error",
                    "Error", JOptionPane.ERROR_MESSAGE);
            quit();
        }
    }

    private void quit() {
        if (chatServer != null) {
            try {
                chatServer.disconnect(userName);
            } catch (Exception e) {
            }
        }
        System.exit(0);
    }

    private void sendMessage() {
        try {
            chatServer.sendChatMessage(userName, txtMessage.getText());
            txtMessage.setText(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Connection error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Called by CallBackRemoteObject (when the server sent a message to it)
    public void update(Observable o, Object arg) {
        txtDisplay.append(arg.toString() + '\n');
        txtDisplay.setCaretPosition(txtDisplay.getDocument().getLength());
    }

    public static void main(String[] args) {
        final JFrame frame = new ChatClient();
        frame.setVisible(true);
    }

}
