package vn.edu.rmit.sadi;

import java.util.ArrayList;

public abstract class SortAlgorithm {

    public abstract void sort(ArrayList<Integer> l);

    protected void swap(ArrayList<Integer> list, int i, int j) {
        Integer tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
