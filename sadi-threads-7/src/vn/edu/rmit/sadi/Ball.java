package vn.edu.rmit.sadi;

import javax.swing.*;
import java.awt.*;

public class Ball implements Runnable {

    public int x;
    public int y;
    public int dirX;
    public int dirY;
    public Color color;
    private JPanel panel;

    public Ball(JPanel p) {
        this.color = new Color(Utils.RANDOM.nextInt(256), Utils.RANDOM.nextInt(256), Utils.RANDOM.nextInt(256));
        this.panel = p;
        this.x = Utils.RANDOM.nextInt(panel.getWidth() - Utils.BALL_SIZE);
        this.y = Utils.RANDOM.nextInt(panel.getHeight() - Utils.BALL_SIZE);
        this.dirX = Utils.RANDOM.nextBoolean() ? 1 : -1;
        this.dirY = Utils.RANDOM.nextBoolean() ? 1 : -1;
    }

    public void move() {
        x += dirX;
        y += dirY;
        if(x < 0 || x > (panel.getWidth() - Utils.BALL_SIZE)) {
            dirX = -dirX;
        }
        if(y < 0 || y > (panel.getHeight() - Utils.BALL_SIZE)) {
            dirY = -dirY;
        }
    }

    @Override
    public void run() {
        while(true) {
            move();
            panel.repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                //do nothing
            }
        }
    }


}
