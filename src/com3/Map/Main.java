/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/8 03:04
 */

package com3.Map;

import AInterface.Map;
import com.Set.FileOperation;

import java.util.ArrayList;

public class Main {

    private static double testSet(Map<String, Integer> map, String filename){

        long startTime = System.nanoTime();

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile(filename,words);

        System.out.println("Total words: " + words.size());

        for (String word : words) {
            word = word.trim();
            if(map.contains(word)){
                map.set(word, map.get(word) + 1);
            }else{
                map.add(word, 1);
            }
        }
        System.out.println("Total different words:  " + map.getSize());

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args){

        String filename = "pride-and-Prejudice.txt";
        Map<String, Integer> bstMap = new BSTMap<>();
        double time1 = testSet(bstMap, filename);
        System.out.println("bstMap: " + time1 + "s");

        System.out.println();

//        Map<String, Integer> linkedListMap = new LinkedListMap<>();
//        double time2 = testSet(linkedListMap, filename);
//        System.out.println("BST linkedListMap: " + time2 + "s");

        System.out.println();

        Map<String, Integer> avlMap = new AVLMap<>();
        double time3 = testSet(avlMap, filename);
        System.out.println("avlMap: " + time3 + "s");
                
    }

}
