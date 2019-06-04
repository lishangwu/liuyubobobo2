/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 02:10
 */

package com3.test;

import AInterface.Stack;
import com3.Linked.LinkedListStack;

public class LinkedListStackTest {

    public static void main(String[] args){
        
        Stack<Integer> stack = new LinkedListStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            stack.print();
        }

        stack.pop();
        stack.print();
    }

}
