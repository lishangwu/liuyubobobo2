/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/28 01:23
 */

package com.Set;

import java.util.ArrayList;

/**
 * Created by robin on 2019/1/28.
 */
public class Test {

    public static void main(String[] args){

        long time1 = System.nanoTime();
        System.out.println("pride-and-Prejudice.txt");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-Prejudice.txt",words1);

        System.out.println("Total words: " + words1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for (String s : words1) {
            set1.add(s);
        }
        System.out.println("Total different words: " + set1.getSize());

        long time2 = System.nanoTime();

        System.out.println((time2 - time1) / 1000000000.0);

        System.out.println();

        System.out.println("A-Tale-of-Two-Cities.txt");

        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("A-Tale-of-Two-Cities.txt",words2);

        System.out.println("Total words: " + words2.size());

        BSTSet<String> set2 = new BSTSet<>();
        for (String s : words2) {
            set2.add(s);
        }
        System.out.println("Total different words: " + set2.getSize());


    }

}
