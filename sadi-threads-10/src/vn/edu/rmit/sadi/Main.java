package vn.edu.rmit.sadi;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Inventory inv = new Inventory(5, 100);
        // 20 threads will be updating one of the 5 product types
        for (int i = 0; i < 10; i++) {
            new WithdrawThread("withdraw: "+i, inv, i % 5).start();
            new ReplenishThread("replenish: "+i, inv, i % 5).start();
        }

    }
}
