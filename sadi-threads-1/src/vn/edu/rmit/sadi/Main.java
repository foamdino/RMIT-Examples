package vn.edu.rmit.sadi;

public class Main {

    public static void main(String[] args) {

        PrintThread pt1 = new PrintThread(10000);
        pt1.start();
        PrintThread pt2 = new PrintThread(20000);
        pt2.start();

    }
}
