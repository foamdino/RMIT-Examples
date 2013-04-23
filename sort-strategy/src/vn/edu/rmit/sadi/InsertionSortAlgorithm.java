package vn.edu.rmit.sadi;

import java.util.ArrayList;

public class InsertionSortAlgorithm extends SortAlgorithm {

    @Override
    public void sort(ArrayList<Integer> l) {
        for(int i=1; i<l.size(); i++) {
            int key = l.get(i);
            int position = i;
            while(position > 0 && key < l.get(position -1)){
                l.set(position, l.get(position-1));
                position--;
            }
            l.set(position, key);
        }
    }
}
