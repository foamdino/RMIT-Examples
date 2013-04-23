package vn.edu.rmit.sadi;

public class Inventory {

    private int[] productTypeQuantities;

    public Inventory(int numberOfProductTypes, int initialQty) {
        productTypeQuantities = new int[numberOfProductTypes];
        for(int i=0; i < numberOfProductTypes; i++) {
            productTypeQuantities[i] = initialQty;
        }
    }

    public void replenish(String threadName, int productType, int quantity) {
        System.out.println(threadName+" : "+"In replenish: Product Type = " + productType + " level " + productTypeQuantities[productType] + " qty = " + quantity);
        int amount = productTypeQuantities[productType];
        amount = amount + quantity;
        productTypeQuantities[productType] = amount;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            // do nothing
        }
    }

    public void withdraw(String threadName, int productType, int quantity) {
        while(productTypeQuantities[productType] < quantity) {
            // wait until available
        }
        System.out.println(threadName+" : "+"In withdraw: Product Type = " + productType + " level " + productTypeQuantities[productType] + " qty = " + quantity);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ie) {
            // do nothing
        }
        int amount = productTypeQuantities[productType] - quantity;
        if (amount < 0) {
            System.err.println("Logic error: quantity below 0 = " + amount);
            System.exit(1);
        }
        productTypeQuantities[productType] = amount;
    }

}
