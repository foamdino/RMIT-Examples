package vn.edu.rmit.sadi;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Runnable {
    //private int counter;
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        for(int i=0; i<10000; i++) {
            counter.incrementAndGet();
        }
    }

    public String toString() {
        return ""+counter;
    }
}
