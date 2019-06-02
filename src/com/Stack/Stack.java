package com.Stack;

/**
 * Created by robin on 2019/1/25.
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
