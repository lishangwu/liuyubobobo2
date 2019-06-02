/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/25 19:20
 */

package com.Queue;

import com.Array.Array;

/**
 * Created by robin on 2019/1/25.
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpgy();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){
        
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayQueue.enqueue(i);
            if(i % 3 == 2){
                arrayQueue.dequeue();
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            loopQueue.enqueue(i);
            if(i % 3 == 2){
                loopQueue.dequeue();
            }
        }
        long time4 = System.currentTimeMillis();
        System.out.println(time4 - time3);



    }
}
