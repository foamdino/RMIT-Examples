package vn.edu.rmit.sadi;

public class Main {

    public static void main(String[] args) {
        PrintThread pT1 = new PrintThread(10000);
        pT1.start();
        PrintThread pT2 = new PrintThread(20000);
        pT2.start();
        System.out.println("In Main Before loop");
        while (pT1.isAlive() || pT2.isAlive()){
            // empty loop
        }
        System.out.println();
        System.out.println("In main After loop");

    }
}
