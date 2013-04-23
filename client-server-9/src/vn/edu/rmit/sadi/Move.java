package vn.edu.rmit.sadi;

import java.io.Serializable;

public class Move implements Serializable {

    public int x;
    public int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
