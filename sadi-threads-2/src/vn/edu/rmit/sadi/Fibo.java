package vn.edu.rmit.sadi;

/**
 *
 */
public class Fibo {

    private int first = 1;
    private int second = 1;
    private int term = 1;

    public int getNext() {
        int val;
        if(term == 1) {
            val = 1;
        } else {
            val = first + second;
            first = second;
            second = val;
        }
        term++;
        return val;
    }

}
