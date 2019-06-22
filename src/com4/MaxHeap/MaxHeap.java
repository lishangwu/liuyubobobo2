/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/13 00:48
 */

package com4.MaxHeap;

import AInterface.Heap;
import com4.Array.Array;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for(int i = parent(data.getSize() - 1); i>=0; i--){
            siftDown(i);
        }
    }


    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int parent(int index) {
        if(index == 0)
            throw new IllegalArgumentException("index - 0 doesn't have parent.");
        return (index - 1) / 2;
    }

    @Override
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    @Override
    public int rightChild(int index) {
        return index * 2 + 1 + 1;
    }

    @Override
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

//    @Override
    public E findMax() {
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");

        return data.get(0);
    }

//    @Override
    public E extracMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    @Override
    public void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    @Override
    public void siftDown(int k) {
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);

            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }

            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }

            data.swap(j, k);
            k = j;
        }
    }

    @Override
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    @Override
    public void print() {
        for (int i = 0; i < data.getSize(); i++) {
            System.out.print(data.get(i));
            System.out.print("\t");
        }
        System.out.println();
    }
}
