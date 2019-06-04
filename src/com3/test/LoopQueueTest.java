/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 00:02
 */

package com3.test;

import AInterface.Queue;
import com3.Queue.LoopQueue;

public class LoopQueueTest {

    public static void main(String[] args){

        Queue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        queue.print();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println();
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }

    }

}
