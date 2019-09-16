/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/22 18:46
 */

package com5.Linked;

import AInterface.Linked;

public class LinkedList<E> implements Linked<E> {

    private class Node{
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
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
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
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed. Illegal index.");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        size ++;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed. Illegal index.");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        return pre.next.e;
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
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Set Failed. Illegal index.");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next.e = e;
    }

    @Override
    public boolean contains(E e) {

        Node pre = dummyHead;
        while (pre.next != null){
            if(pre.next.e.equals(e))
                return true;
            pre = pre.next;
        }

//        Node cur = dummyHead.next;
//        while (cur != null){
//            if(cur.next.equals(e))
//                return true;
//            cur = cur.next;
//        }

        return false;
    }

    @Override
    public E remove(int index) {
        if(index < 0 && index > size)
            throw new IllegalArgumentException("Remove Failed. Illegal index.");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        Node ret = pre.next;
        pre.next = pre.next.next;
        size --;

        return ret.e;
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
        Node pre = dummyHead;
        while (pre.next != null){
            if(pre.next.e.equals(e))
                break;
            pre = pre.next;
        }

        if(pre.next != null)
            pre.next = pre.next.next;
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
            res.append(pre.e + "->");
            pre = pre.next;
        }

        return res.toString();
    }
}
