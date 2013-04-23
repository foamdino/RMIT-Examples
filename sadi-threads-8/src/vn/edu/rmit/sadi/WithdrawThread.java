package vn.edu.rmit.sadi;

public class WithdrawThread extends Thread {
    private Inventory inv;
    private int itemIndex;

    public WithdrawThread(String id, Inventory inv, int index) {
        super(id);
        this.inv = inv;
        this.itemIndex = index;
    }

    @Override
    public void run() {
        while(true) {
            int qty = (int) (100 * Math.random());  // qty = 1 - 100
            inv.withdraw(getName(), itemIndex, qty);
        }
    }

}
