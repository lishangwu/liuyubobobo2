/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/9 03:04
 */

package com3.MaxHeap;

import AInterface.Queue;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        this.maxHeap = new MaxHeap<>();
    }

    @Override
    public int getCapacity() {
        return maxHeap.size();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extracMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public void print() {

    }


}
