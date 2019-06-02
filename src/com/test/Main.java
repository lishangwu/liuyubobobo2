/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/24 01:30
 */

package com.test;

import com.Queue.ArrayQueue;
import com.Queue.LoopQueue;
import com.Queue.Queue;

import java.util.Random;

/**
 * Created by robin on 2019/1/24.
 */
public class Main {

    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println(time1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println(time2);

        System.out.println(time1 / time2);

    }

}
