package vn.edu.rmit.sadi;

public class PrintThread extends Thread {

    private int num = -1;
    private int initial;

    public PrintThread(int i) {
        this.initial = i;
    }

    public PrintThread(int i, int n) {
        this.initial = i;
        this.num = n;
    }

    @Override
    public void run() {
        for (int i=initial; i<= initial + 100; i++) {
            System.out.print(" " + i);
            // try – catch Needed when calling sleep
            try {
                if (i == num) {
                    Thread.sleep(10);
                }
            } catch (InterruptedException ex) {
                //Do nothing
            }
        }

    }
}
