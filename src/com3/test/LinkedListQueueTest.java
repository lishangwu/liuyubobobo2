/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 02:23
 */

package com3.test;

import AInterface.Queue;
import com3.Linked.LinkedListQueue;

public class LinkedListQueueTest {

    public static void main(String[] args){

        Queue<Integer> queue = new LinkedListQueue<>();
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            queue.print();
            if(i % 3 == 2){
                queue.dequeue();
                queue.print();
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }

}
