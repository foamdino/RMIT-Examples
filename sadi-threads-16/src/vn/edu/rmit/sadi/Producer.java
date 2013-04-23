package vn.edu.rmit.sadi;

public class Producer implements Runnable {

    private String greeting;
    private Queue queue;
    private int repetitions;
    private static final int DELAY = 10;

    // Constructs the producer object. It takes the queue, the number of
    // repetition and greetings to insert into a queue
    public Producer(String aGreeting, Queue aQueue, int reps) {
        greeting = aGreeting;
        queue = aQueue;
        repetitions = reps;
    }

    public void run() {
        try {
            int i = 1;
            while (i <= repetitions) {
                if (!queue.isFull()) {
                    queue.addToTail(i + ": " + greeting);
                    i++;
                }
                Thread.sleep((int)(Math.random() * DELAY));
            }
        } catch (InterruptedException exception) {
            // do nothing
        }
    }
}
