package vn.edu.rmit.sadi;

public class MasterLockDemo {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static final Object gate = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                synchronized(gate) {
                    synchronized(lock1) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ie) {}

                        synchronized(lock2) {
                            System.out.println("No chance to get here");
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                synchronized(gate) {
                    synchronized(lock2) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ie) {}
                        synchronized(lock1) {
                            System.out.println("No chance to get here");
                        }
                    }
                }
            }
        }).start();
    }
}
