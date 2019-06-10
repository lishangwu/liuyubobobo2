/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/8 18:41
 */

package leetcode;

public class MinStack2 {

    int size;
    int[] stack = new int[20000];
    int min = Integer.MAX_VALUE;

    public MinStack2() {

    }

    public void push(int x) {
        stack[size] = x;
        size ++;

        min = Math.min(x, min);
        stack[size] = min;
        size ++;
    }

    public void pop() {
        if(size == 0){
            return;
        }

        size = size - 2;
        if(size == 0){
            min = Integer.MAX_VALUE;
            return;
        }
        min = stack[size - 1];

    }

    public int top() {
        return stack[size - 2];
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args){

        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());


    }

}
