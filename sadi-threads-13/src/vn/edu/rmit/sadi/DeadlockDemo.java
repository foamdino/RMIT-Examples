package vn.edu.rmit.sadi;

/**
 * In this example, we have reordered the locks to always try to get a lock
 * on lock2 first, this ensures that deadlock won't happen.
 */
public class DeadlockDemo {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        // anonymous thread 1
        new Thread(new Runnable() {

            public void run() {
                // get a lock on 1st object
                synchronized (lock2) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ie) {
                        // do nothing
                    }

                    // try to get a lock on 2nd object
                    synchronized (lock1) {
                        System.out.println("No chance to get here");
                    }
                }
            }
        }).start();

        // anonymous thread 2
        new Thread(new Runnable() {

            public void run() {
                // get a lock on 2nd object
                synchronized (lock2) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // do nothing
                    }

                    // try to get a lock on 1st object
                    synchronized (lock1) {
                        System.out.println("No chance to get here");
                    }
                }
            }
        }).start();

    }
}
