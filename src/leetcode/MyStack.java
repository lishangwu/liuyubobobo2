/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/8 17:42
 */

package leetcode;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()){
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(q1.isEmpty()){
            throw new NoSuchElementException("stack is empty");
        }

        return q1.remove();
    }

    /** Get the top element. */
    public int top() {
        if(q1.isEmpty()){
            throw new NoSuchElementException("stack is empty");
        }

        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
    
    public static void main(String[] args){

        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
                
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */