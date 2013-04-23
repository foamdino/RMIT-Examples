package vn.edu.rmit.sadi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final BallPanel ballPanel = new BallPanel();
        final JButton button = new JButton("Create");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Ball ball = new Ball(ballPanel);
                ballPanel.addBall(ball);
                Thread thread = new Thread(ball);
                thread.start();
            }
        });
        frame.add(button, BorderLayout.NORTH);
        frame.add(ballPanel);
        frame.setSize(Utils.WIDTH, Utils.HEIGHT);
        frame.setVisible(true);
        frame.setTitle("UI & Multi-threading");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
