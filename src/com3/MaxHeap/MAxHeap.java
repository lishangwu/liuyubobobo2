/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/9 01:59
 */

package com3.MaxHeap;

import com3.Array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    //heapify
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        //从最后一个叶子节点的父节点开始sift down (最后一个非叶子节点)
        for(int i=parent((data.getSize() - 1)); i>=0; i--){
            siftDown( i );
        }
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1)/2;
    }
    private int leftChild(int index){
        return index * 2 + 1;
    }
    private int rightChild(int index){
        return index * 2 + 1 + 1;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while ( k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");

        return data.get(0);
    }

    //提取最大元素
    public E extracMax(){
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            //找出左右哪个大
            if( j+1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0 ){
                j = rightChild(k);
            }
            //data[j] 是leftChild 和 rightChild 中的最大值
            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(j, k);
            k = j;
        }
    }

    //取出最大元素，并替换成e
    public E replace(E e){
        E ret = findMax();
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
