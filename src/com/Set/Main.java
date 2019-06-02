/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/28 02:00
 */

package com.Set;

import java.util.ArrayList;

/**
 * Created by robin on 2019/1/28.
 */
public class Main {

    private static double testSet(Set<String> set, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile(filename,words1);

        System.out.println("Total words: " + words1.size());

        for (String s : words1) {
            set.add(s);
        }
        System.out.println("Total different words: " + set.getSize());

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args){

        String filename = "pride-and-Prejudice.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + "s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);

        System.out.println("linked List Set: " + time2 + "s");


    }

}
