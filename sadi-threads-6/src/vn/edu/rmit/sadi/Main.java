package vn.edu.rmit.sadi;

public class Main {

    private Thread pT1 = new PrintThread(10000);
    private Thread pT2 = new PrintThread(20000);

    public Main() {
        pT1.start();
        pT2.start();
    }

    public static void main(String[] args) {
        new Main();
    }

    class PrintThread extends Thread {

        private int initial;

        public PrintThread(int val) {
            initial = val;
        }

        @Override
        public void run() {
            for (int i=1; i<= 100; i++) {
                System.out.print(" " + (initial +i));
                try {
                    if (i == 50 && Thread.currentThread() == pT1) {
                        pT2.join();
                    }
                } catch ( InterruptedException ex){
                    // do nothing
                }
            }
        }

    }
}
