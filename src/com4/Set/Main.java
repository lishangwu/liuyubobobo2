/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/13 00:03
 */

package com4.Set;

import AInterface.Set;
import com.Set.FileOperation;

import java.util.ArrayList;

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
        for (String s : words1) {
            set.contains(s);
        }
        System.out.println("Total different words:  " + set.getSize());

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args){

        String filename = "pride-and-Prejudice.txt";
//        Set<String> bstSet = new BSTSet<>();
//        double time1 = testSet(bstSet, filename);
//        System.out.println("BST BSTSet: " + time1 + "s");

        System.out.println();

        Set<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("BST linkedListSet: " + time2 + "s");

        System.out.println();

//        Set<String> avlSet = new AVLSet<>();
//        double time3 = testSet(avlSet, filename);
//        System.out.println("BST avlSet: " + time3 + "s");

    }

}
