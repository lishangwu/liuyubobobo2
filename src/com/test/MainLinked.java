/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/26 02:52
 */

package com.test;

import com.Linked.LinkedList;

/**
 * Created by robin on 2019/1/26.
 */
public class MainLinked {

    public static void main(String[] args){

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);

        System.out.println(linkedList);

        linkedList.remove(2);

        System.out.println(linkedList);

        linkedList.removeFirst();

        System.out.println(linkedList);

        linkedList.removeLast();

        System.out.println(linkedList);

    }

}
