/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/22 13:10
 */

package Test;

import AInterface.Queue;
import com5.Queue.ArrayQueue;

import java.util.Random;

public class QueueTest {

    private static double testQuee(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }


        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args){

        int opCount = 100000;

        Queue<Integer> arrayQueue = new ArrayQueue<>();
//        Queue<Integer> loopQueue = new LoopQueue<>();
//        Queue<Integer> linkedListQueue = new LinkedListQueue<>();

        System.out.println(testQuee(arrayQueue, opCount));
//        System.out.println(testQuee(loopQueue, opCount));
//        System.out.println(testQuee(linkedListQueue, opCount));

    }

}
