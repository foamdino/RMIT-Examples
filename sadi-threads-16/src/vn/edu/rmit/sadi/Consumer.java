package vn.edu.rmit.sadi;

public class Consumer implements Runnable {
    private Queue queue;
    private int repetitions;
    private static final int DELAY = 10;

    // Constructs consumer object taking the queue from which to retrieve
    // and the number of arguments
    public Consumer(Queue aQueue, int reps) {
        queue = aQueue;
        repetitions = reps;
    }

    public void run() {
        try {
            int i = 1;
            while (i <= repetitions) {
                if (!queue.isEmpty()) {
                    Object greeting = queue.removeFirst();
                    System.out.println(greeting);
                    i++;
                }
                Thread.sleep((int)(Math.random() * DELAY));
            }
        } catch (InterruptedException exception) {
            //do nothing
        }
    }



}
