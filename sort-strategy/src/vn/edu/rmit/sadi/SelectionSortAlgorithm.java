package vn.edu.rmit.sadi;

import java.util.ArrayList;

public class SelectionSortAlgorithm extends SortAlgorithm {

    @Override
    public void sort(ArrayList<Integer> l) {
        for(int i=0; i<l.size()-1; i++) {
            int smallest = i;
            for(int j = i+1; j < l.size(); j++) {
                if(l.get(j) < l.get(smallest)) {
                    smallest = j;
                }
            }
            swap(l, i, smallest);
        }
    }
}
