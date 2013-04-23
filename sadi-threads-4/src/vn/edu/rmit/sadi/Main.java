package vn.edu.rmit.sadi;

public class Main {

    public static void main(String[] args) {
        PrintThread pT1 = new PrintThread(10000, 10050);
        pT1.start();
        PrintThread pT2 = new PrintThread(20000);
        pT2.start();
    }
}
