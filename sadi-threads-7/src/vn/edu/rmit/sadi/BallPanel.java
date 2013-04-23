package vn.edu.rmit.sadi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BallPanel extends JPanel {
    private List<Ball> balls = new ArrayList<Ball>();

    public void addBall(Ball b) {
        balls.add(b);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, Utils.WIDTH, Utils.HEIGHT);
        for (Ball ball : balls) {
            g.setColor(ball.color);
            g.fillOval(ball.x, ball.y, Utils.BALL_SIZE, Utils.BALL_SIZE);
        }
    }
}
