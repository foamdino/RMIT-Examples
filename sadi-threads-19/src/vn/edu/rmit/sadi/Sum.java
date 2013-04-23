package vn.edu.rmit.sadi;

import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Long> {

    public static final int THRESHOLD = 5000;
    private int low;
    private int high;
    private int[] a;

    public Sum(int[] arr, int low, int high) {
        this.low = low;
        this.high = high;
        this.a = arr;
    }

    protected Long compute() {
        if((high - low) < THRESHOLD) {
            long sum = 0;
            for(int i=low; i<high; i++) {
                sum += a[i];
            }
            return sum;
        } else {
            int mid = low + (high - low) / 2;
            Sum leftSum  = new Sum(a, low, mid);
            Sum rightSum = new Sum(a, mid, high);
            leftSum.fork();
            long right = rightSum.compute();
            long left = leftSum.join();
            return left + right;
        }
    }
}
