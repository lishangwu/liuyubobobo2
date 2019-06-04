/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 00:37
 */

package com3.Queue;

import AInterface.Queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
//        return size == 0;
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if( (tail+1) % data.length == front )
            resize(data.length * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Can't dequeue from an empty  queue");

        E ret = data[front];

        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        if(size == getCapacity()/4 && getCapacity()/2 != 0)
            resize(getCapacity()/2);

        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Can't dequeue from an empty  queue");
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[ (i+front) % data.length ];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");

        for (int i=front; i != tail; i = (i+1)%data.length){
            res.append(data[i]);
            if( (i+1)%data.length != tail )
                res.append(", ");
        }

        res.append("] tail");

        return res.toString();
    }
}
