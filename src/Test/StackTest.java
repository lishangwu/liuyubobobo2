/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/22 13:10
 */

package Test;

import AInterface.Stack;
import com5.Stack.ArrayStack;

import java.util.Random;

public class StackTest {

    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }


        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){

        int opCount = 100000;

        Stack<Integer> arrayStack = new ArrayStack<>();//需要resize，扩容
//        Stack<Integer> linkedListStack = new LinkedListStack<>();// 需要不停new Node, 开辟新空间

        System.out.println(testStack(arrayStack, opCount));
//        System.out.println(testStack(linkedListStack, opCount));

    }

}
