package vn.edu.rmit.sadi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo implements Runnable {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void run() {
        System.out.println("running");
        while (true) {
            if (!lock1.tryLock()) {
                sleep();
                continue;
            }
            try {
                if (!lock2.tryLock()) {
                    sleep();
                    continue;
                }
                try {
                    // critical section
                    break;
                } finally {
                    lock2.unlock();
                }
            } finally {
                lock1.unlock();
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {}
    }


    public static void main(String[] args) {
        new Thread(new TryLockDemo()).start();

        new Thread(new TryLockDemo()).start();
    }
}
