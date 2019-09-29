/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/26 15:22
 */

package com6.AVLTree;

import AInterface.Map;
import com.Set.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static double test(Map<String, Integer> map, ArrayList<String> words){
        Collections.sort(words);
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

        AVLMap<String, Integer> avlMap = new AVLMap<>();
        BSTTree<String, Integer> bstTree = new BSTTree<>();

        System.out.println("avlMap: " + test(avlMap, words));
        System.out.println("bstTree: " + test(bstTree, words));

    }

}
