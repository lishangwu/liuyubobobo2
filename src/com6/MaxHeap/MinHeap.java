/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/21 04:51
 */

package com6.MaxHeap;

import com6.Array.Array;

public class MinHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap(E[] arr) {
        data = new Array<>(arr);
        for(int i=parent(data.getSize() - 1); i>=0; i--){
            siftDown(i);
        }
    }

    public MinHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 1 + 1;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMin() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMin when heap is empty.");
        return data.get(0);
    }

    public E extracMin() {
        E ret = findMin();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            //找出左右哪个xiao
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) < 0) {
                j = rightChild(k);
            }
            //data[j] 是leftChild 和 rightChild 中的最xiao值
            if(data.get(k).compareTo(data.get(j)) <=0){
                break;
            }
            data.swap(j,k);
            k = j;
        }
    }

    //取出最大元素，并替换成e
    public E replace(E e){
        E ret = findMin();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public void print(){
        for (int i = 0; i < data.getSize(); i++) {
            System.out.print(data.get(i));
            System.out.print("\t");
        }
        System.out.println();
    }
}
