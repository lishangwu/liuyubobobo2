package com2.Interface;

/**
 * Created by robin on 2019/2/22.
 */
public interface Queue<E> {
    int getCapacity();
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
