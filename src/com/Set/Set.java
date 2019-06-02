package com.Set;

/**
 * Created by robin on 2019/1/28.
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
