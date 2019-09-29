/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/29 19:22
 */

package com7.Queue;

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
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(2 * data.length);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + 1) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new RuntimeException("Can't dequeue from an empty  queue");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && data.length / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new RuntimeException("Can't dequeue from an empty  queue");
        return data[front];
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i=front; i<tail; i = (i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
