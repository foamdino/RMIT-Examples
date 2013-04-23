package vn.edu.rmit.sadi;

import java.util.concurrent.atomic.AtomicReference;

public class NonblockingStack<T> {

    AtomicReference<Node<T>> head = new AtomicReference<Node<T>>();

    public void push(T item) {
        Node<T> newHead = new Node<T>(item);
        Node<T> oldHead;
        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while (!head.compareAndSet(oldHead, newHead));
    }

    public T pop() {
        Node<T> oldHead;
        Node<T> newHead;
        do {
            oldHead = head.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
        } while (!head.compareAndSet(oldHead,newHead));
        return oldHead.value;
    }
}
