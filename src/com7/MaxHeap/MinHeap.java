/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/30 01:01
 */

package com7.MaxHeap;

import com7.Array.Array;

public class MinHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap(E[] arr){
        data = new Array<>(arr);
        //从最后一个叶子节点的父节点开始sift down (最后一个非叶子节点)
        for(int i=parent(data.getSize()-1); i>=0; i--){
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

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k>0 && data.get(k).compareTo(data.get(parent(k))) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMin(){
        if (data.getSize() == 0)
            throw new RuntimeException("Can not findMin when heap is empty.");
        return data.get(0);
    }

    public E extractMax(){
        E ret = findMin();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if(j +1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) < 0){
                j = rightChild(k);
            }
            if(data.get(k).compareTo(data.get(j)) >=0){
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

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
