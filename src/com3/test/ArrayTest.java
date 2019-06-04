/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 00:02
 */

package com3.test;

import com3.Array.Array;

public class ArrayTest {

    public static void main(String[] args){

        Array<Integer> arr = new Array<>();

        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        arr.print();
//        arr.addFirst(123);
        arr.remove(4);
        arr.print();
        arr.removeFirst();
        arr.print();
        arr.removeLast();
        arr.print();

    }

}
