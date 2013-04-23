package vn.edu.rmit.sadi;

public class Main {

    public static void main(String[] args) {
        PrintThread pt1 = new PrintThread(10000);
        pt1.start();
        Thread fibThread = new Thread(new RunnableFibo());
        fibThread.start();
    }
}
