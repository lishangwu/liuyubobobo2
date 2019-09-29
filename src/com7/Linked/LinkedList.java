/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/29 19:58
 */

package com7.Linked;

import AInterface.Linked;

public class LinkedList<E> implements Linked<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed. Illegal index.");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
//        Node node = new Node(e, pre.next);
//        pre.next = node;

        pre.next = new Node(e, pre.next);
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed. Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.next.e;
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set Failed. Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next.e = e;
    }

    @Override
    public boolean contains(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e))
                return true;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove Failed. Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = prev.next.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }
        if(prev.next != null)
            prev.next = prev.next.next;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node pre = dummyHead;
        while (pre.next != null){
            res.append(pre.next + "->");
            pre = pre.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
