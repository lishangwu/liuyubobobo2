/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/21 15:38
 */

package com6.MaxHeap;

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
