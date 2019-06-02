/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/29 05:06
 */

package com.MaxHeap;

import com.Queue.Queue;

/**
 * Created by robin on 2019/1/29.
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
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


}
