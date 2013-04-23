package vn.edu.rmit.sadi;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        SortableIntList list = buildList();
        list.setSortAlgorithm(new SelectionSortAlgorithm());
        sortList(list);
        list = buildList();
        list.setSortAlgorithm(new InsertionSortAlgorithm());
        sortList(list);
    }

    private static SortableIntList buildList() {
        Random random = new Random();
        final SortableIntList list = new SortableIntList();
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(1000));
        }
        return list;
    }

    private static void sortList(final SortableIntList list) {
        long start = System.currentTimeMillis();
        list.sort();
        System.out.printf("Elapsed: %dms \n", System.currentTimeMillis() - start);
    }

}
