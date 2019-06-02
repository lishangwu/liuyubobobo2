package com.Queue;

/**
 * Created by robin on 2019/1/25.
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
