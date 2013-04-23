package vn.edu.rmit.sadi;

/**
 *
 */
public class RunnableFibo extends Fibo implements Runnable {

    @Override
    public void run() {
        for(int i=1; i<=30; i++) {
            System.out.println(" F("+i+")="+getNext());
        }
    }
}
