/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/12 20:55
 */

package com4.Linked;

import AInterface.Stack;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

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
        list.addLast(e);
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public E peek() {
        return list.getLast();
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
