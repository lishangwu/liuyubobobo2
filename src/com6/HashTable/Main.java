/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/27 17:39
 */

package com6.HashTable;

import AInterface.Map;
import com.Set.FileOperation;
import com6.AVLTree.AVLMap;
import com6.Map.BSTMap;

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
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("pride-and-Prejudice.txt", words);

        for (int i = 0; i < 10; i++) {
            for (String word : words) {
                words2.add(word);
            }
        }
        words = words2;

        AVLMap<String, Integer> avlMap = new AVLMap<>();
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        HashTable<String, Integer> hashTable = new HashTable<>();
//        HashTable<String, Integer> hashTable2 = new HashTable<>(131071);

        System.out.println(test(avlMap, words));
        System.out.println(test(bstMap, words));
        System.out.println(testHash(hashTable, words));
//        System.out.println(testHash(hashTable2, words));



    }

}
