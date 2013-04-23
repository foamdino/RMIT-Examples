package vn.edu.rmit.sadi;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        new Main().testForkJoin();
    }

    private void testForkJoin() {
        int[] data = randomData(10000);
        long sum = 0;
        for(Integer i: data) {
            sum += i;
        }
        System.out.println("sum using sequential code: "+sum);

        ForkJoinPool pool = new ForkJoinPool();

        Sum s = new Sum(data, 0, data.length);
        long v = pool.invoke(s);

        System.out.println("sum using ForkJoinPool: "+v);
    }

    private int[] randomData(int size) {
        int[] data = new int[size];
        Random generator = new Random(42);
        for(int i=0; i<size; i++) {
            data[i] = generator.nextInt(10);
        }

        return data;
    }
}
