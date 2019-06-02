package com2.Interface;

/**
 * Created by robin on 2019/2/22.
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
