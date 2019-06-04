/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 02:13
 */

package com3.Linked;

import AInterface.Queue;

public class LinkedListQueue<E> implements Queue<E> {

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

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getCapacity() {
        return 0;
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
    public void enqueue(E e) {

        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }

        size ++;
    }

    @Override
    public E dequeue() {

        if(isEmpty())
            throw new IllegalArgumentException("Can't dequeue from an empty queue");

        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if(head == null)
            tail = null;

        size --;

        return retNode.e;
    }

    @Override
    public E getFront() {

        if(isEmpty())
            throw new IllegalArgumentException("Can't getFront from an empty queue");

        return head.e;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");

        return res.toString();
    }
}