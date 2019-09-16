/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/22 18:35
 */

package com5.Stack;

import AInterface.Stack;
import com5.Array.Array;

public class ArrayStack<E> implements Stack<E>{

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack : ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize())
                res.append(", ");
        }
        res.append("] top");

        return res.toString();
    }
}
