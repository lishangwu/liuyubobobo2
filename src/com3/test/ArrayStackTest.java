/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 00:02
 */

package com3.test;

import AInterface.Stack;
import com3.Stack.ArrayStack;

public class ArrayStackTest {

    public static void main(String[] args){

        Stack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.peek());


    }

}
