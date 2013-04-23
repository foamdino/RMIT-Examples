package vn.edu.rmit.sadi;

/**
 *
 */
public class PrintThread extends Thread {

    private int initial;

    public PrintThread(int val) {
        initial = val;
    }

    @Override
    public void run() {
        for(int i=initial; i<=(initial+100); i++) {
            System.out.println(" " + i);
        }
    }
}
