package vn.edu.rmit.sadi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame implements Runnable {
    public static void main(String[] args) throws IOException {
        new Client();
    }

    private Player me;
    private Communicator server;
    private JLabel lblMessage;
    private JButton[] buttons;
    private boolean myTurn;

    public Client() throws IOException {
        initializeUI();
        initializeConnection();
        new Thread(this).start();
    }

    private void initializeConnection()
            throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 9999);
        ObjectOutputStream oos = new ObjectOutputStream(
                socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(
                socket.getInputStream());
        server = new Communicator(socket, ois, oos);
    }

    private void initializeUI() {
        lblMessage = new JLabel("Waiting to play...");
        lblMessage.setPreferredSize(new Dimension(60, 20));
        add(lblMessage, BorderLayout.SOUTH);
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(3, 3));

        buttons = new JButton[9];
        for (int i = 0; i < buttons.length; i++) {
            JButton button = createButton(i);
            buttons[i] = button;
            btnPanel.add(button);
        }

        add(btnPanel);
        setVisible(true);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton createButton(final int index) {
        final JButton button = new JButton();
        button.setPreferredSize(new Dimension(50, 50));
        button.setFont(new Font("Arial", Font.BOLD, 40));

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!myTurn) return;
                button.setText(me == Player.Player1 ? "O" : "X");
                button.setEnabled(false);
                myTurn = false;
                lblMessage.setText("Opponent's turn");
                server.write(new Move(index/3, index%3));
            }
        });

        return button;
    }

    public void run() {
        Object message = server.read();
        while (message != null) {

            if (message instanceof Player) {
                me = (Player)message;
                this.setTitle(me.toString());

            } else if (message instanceof Move) {
                Move move = (Move)message;
                JButton button = buttons[move.x*3 + move.y];
                button.setText(me == Player.Player1 ? "X" : "O");
                button.setEnabled(false);

            } else if (message instanceof Status) {
                Status status = (Status)message;

                if (status == Status.Continue) {
                    lblMessage.setText("Your turn");
                    myTurn = true;

                } else { // win, lose, tie
                    String msg = status == Status.Win ? "You won!"
                            : status == Status.Lose ? "You lose!"
                            : "Tie!";
                    lblMessage.setText(msg);
                    return;
                }
            }
            message = server.read();
        }
    }

}
