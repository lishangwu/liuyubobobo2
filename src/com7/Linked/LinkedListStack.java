/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/29 20:22
 */

package com7.Linked;

import AInterface.Stack;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
