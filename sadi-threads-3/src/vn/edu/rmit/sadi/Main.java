package vn.edu.rmit.sadi;

public class Main {

    public static void main(String[] args) {
        PrintThread pT1 = new PrintThread(10000);   // First Thread instance
        pT1.setPriority(Thread.MAX_PRIORITY);
        System.out.println(pT1.getPriority());
        pT1.start();   // First Thread started
        PrintThread pT2 = new PrintThread(20000);  // Second Thread instance
        pT1.setPriority(Thread.MIN_PRIORITY);
        System.out.println(pT1.getPriority());
        pT2.start();
    }
}
