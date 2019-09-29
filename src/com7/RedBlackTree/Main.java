/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/30 02:56
 */

package com7.RedBlackTree;

import AInterface.Map;
import com.Set.FileOperation;

import java.util.ArrayList;

public class Main {

    public static double test(Map<String, Integer> map, ArrayList<String> words){

//        Collections.sort(words);

        long startTime = System.nanoTime();
        for (String word : words) {
            if(map.contains(word)){
                map.set(word, map.get(word) + 1);
            }else{
                map.add(word, 1);
            }
        }
        for (String word : words) {
            map.contains(word);
        }

        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of of: " + map.get("out"));
        System.out.println("Frequency of the: " + map.get("the"));
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args){

        ArrayList<String> words = new ArrayList<>();

        FileOperation.readFile("pride-and-Prejudice.txt", words);

//        AVLMap<String, Integer> avlMap = new AVLMap<>();
//        BSTMap<String, Integer> bstMap = new BSTMap<>();
        RBMap<String, Integer> rbMap = new RBMap<>();

//        System.out.println(test(avlMap, words));
        System.out.println();
//        System.out.println(test(bstMap, words));
        System.out.println();
        System.out.println(test(rbMap, words));

    }
}
