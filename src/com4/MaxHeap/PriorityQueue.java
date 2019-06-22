/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/13 12:55
 */

package com4.MaxHeap;

import AInterface.Queue;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
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
