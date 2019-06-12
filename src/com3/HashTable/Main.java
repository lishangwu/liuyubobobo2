/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/11 17:12
 */

package com3.HashTable;

import AInterface.Map;
import com.Set.FileOperation;
import com3.AVLTree.AVLTree;
import com3.Map.BSTMap;

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
    public static double testHash(HashTable<String, Integer> map, ArrayList<String> words){


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

        AVLTree<String, Integer> avlTree = new AVLTree<>();
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        HashTable<String, Integer> hashTable = new HashTable<>();//131071

        System.out.println(test(avlTree, words));
        System.out.println(test(bstMap, words));
        System.out.println(testHash(hashTable, words));


    }
}
