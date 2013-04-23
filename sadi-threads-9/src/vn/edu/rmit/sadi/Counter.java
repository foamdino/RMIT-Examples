package vn.edu.rmit.sadi;

public class Counter implements Runnable {

    private int counter;

    @Override
    public void run() {
        for(int i =0; i<10000; i++) {
            counter++;
        }
    }

    @Override
    public String toString() {
        return "" + counter;
    }
}
