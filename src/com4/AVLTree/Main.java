/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/10 11:31
 */

package com4.AVLTree;

import AInterface.Map;
import com.Set.FileOperation;
import com4.Map.BSTMap;

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


        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args){

        ArrayList<String> words = new ArrayList<>();

        FileOperation.readFile("pride-and-Prejudice.txt", words);

        AVLTreeMap<String, Integer> avlTree = new AVLTreeMap<>();
        BSTMap<String, Integer> bstMap = new BSTMap<>();

        System.out.println(test(avlTree, words));
        System.out.println(test(bstMap, words));


    }

}
