/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/24 01:30
 */

package com.test;

import com.Linked.LinkedListStack;
import com.Stack.ArrayStack;
import com.Stack.Stack;

import java.util.Random;

/**
 * Created by robin on 2019/1/24.
 */
public class Main2 {

    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){

        int opCount = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println(time1);

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println(time2);

        System.out.println(time1 / time2);

    }

}
