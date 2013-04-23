package vn.edu.rmit.sadi;

public class ReplenishThread extends Thread {
    private Inventory inv;
    private int productTypeId;

    public ReplenishThread(String id, Inventory inv, int index) {
        super(id);
        this.inv = inv;
        this.productTypeId = index;
    }

    @Override
    public void run() {
        while(true) {
            int qty = (int) (100 * Math.random()); //qty = 1-100
            inv.replenish(getName(), productTypeId, qty);
        }
    }
}
