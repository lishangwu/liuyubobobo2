/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/3 23:34
 */

package com3.Array;

public class Array<E> implements AInterface.Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getCapacity() {
        return this.data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void add(int index, E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Required index>=0 && index<=size");

        if(size == data.length)
            resize(data.length * 2);

        for(int i=size-1; i>=index; i--)
            data[i+1] = data[i];

//        for(int i=index; i<size; i++){
//            data[i+1] = data[i];
//        }

        data[index] = e;
        size ++;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Required index>=0 && index<=size");

        return data[index];
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public void set(int index, E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("BSTSet failed. Required index>=0 && index<=size");

        data[index] = e;

    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Required index>=0 && index<size");

        E ret = data[index];
        for(int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }

        size --;
        data[size] = null;//

        if(size == data.length/4 && data.length/2 != 0)
            resize(data.length/2);

        return ret;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size-1);
    }

    @Override
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void swap(int i, int j) {
        if(i < 0 || i>= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");

        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d \n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size -1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
