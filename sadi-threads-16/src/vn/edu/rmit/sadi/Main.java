package vn.edu.rmit.sadi;

public class Main {

    public static final int REPETITIONS = 10;

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.setDebug(true);
        Runnable run1 = new Producer("Hello, World!", queue, 100);
        Runnable run2 = new Producer("Goodbye, World!", queue, 100);
        Runnable run3 = new Consumer(queue, 2 * REPETITIONS);

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        Thread thread3 = new Thread(run3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
