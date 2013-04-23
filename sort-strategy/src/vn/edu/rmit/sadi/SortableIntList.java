package vn.edu.rmit.sadi;

import java.util.ArrayList;

public class SortableIntList extends ArrayList<Integer> {

    private SortAlgorithm algorithm;

    public void setSortAlgorithm(SortAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void sort() {
        algorithm.sort(this);
    }
}
