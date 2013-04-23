package vn.edu.rmit.sadi;

public class Queue {

    private Object[] elements;
    private int head;
    private int tail;
    private int size;
    private boolean debug;

    public Queue(int capacity) {
        elements = new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    // assumes a non-empty queue
    public Object removeFirst() {
        Object r = elements[head];
        head++;
        size--;
        if(head == elements.length) {
            head = 0;
        }
        return r;
    }

    // assumes non-full queue
    public void addToTail(Object o) {
        elements[tail] = o;
        tail++;
        size++;
        if(tail == elements.length) {
            tail = 0;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public void setDebug(boolean f) {
        debug = f;
    }

}
