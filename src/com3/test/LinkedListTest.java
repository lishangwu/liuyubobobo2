/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 01:56
 */

package com3.test;

import com3.Linked.LinkedList;

public class LinkedListTest {

    public static void main(String[] args){

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }

        list.print();
        list.remove(3);
        list.print();
        list.add(3, 3);
        list.print();
        System.out.println(list.get(3));

    }

}
