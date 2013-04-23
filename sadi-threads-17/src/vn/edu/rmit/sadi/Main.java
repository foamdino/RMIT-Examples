package vn.edu.rmit.sadi;

public class Main {

    public static void main(String[] args) {
        Counter block = new Counter();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(block);
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch(InterruptedException e) {
                //do nothing
            }
        }
        System.out.println(block);

    }
}
