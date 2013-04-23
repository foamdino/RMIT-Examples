package vn.edu.rmit.sadi;

public class Node<T> {

    public T value;
    public Node<T> next;

    public Node(T v) {
        this.value = v;
    }
}
