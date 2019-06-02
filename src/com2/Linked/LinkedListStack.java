/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/2/22 04:05
 */

package com2.Linked;

import com2.Interface.Stack;

/**
 * Created by robin on 2019/2/22.
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        this.list = new LinkedList<>();
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
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
