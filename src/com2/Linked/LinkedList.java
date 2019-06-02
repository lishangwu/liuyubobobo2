/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/2/22 03:38
 */

package com2.Linked;

/**
 * Created by robin on 2019/2/22.
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e){
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
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed. Illegal index.");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        size ++;
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e){
        add(size ,e);
    }

    public E get(int index){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed, Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Set Failed, Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Remove Failed, Illegal index.");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        Node retNode = pre.next;
        pre.next = pre.next.next;
        retNode.next = null;
        size --;
        return retNode.e;

    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        Node pre = dummyHead;
        while (pre.next != null){
            if(pre.e.equals(e))
                break;
            pre = pre.next;
        }

        if(pre.next != null){
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode = null;
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead;
//        while (cur.next != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }

        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");

        res.append("NULL");

        return res.toString();
    }
}
