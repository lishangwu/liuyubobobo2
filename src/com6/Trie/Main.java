/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/24 14:29
 */

package com6.Trie;

import com.Set.FileOperation;
import com6.BST.BST;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("A-Tale-of-Two-Cities2.txt", words)){

            System.out.println("words: " + words.size());
            for (int i = 0; i < 10; i++) {
                for (String word : words) {
                    words2.add(word);
                }
            }
            System.out.println("words2: " + words2.size());
            words = words2;

            long startTime = System.nanoTime();
            BST<String> set = new BST<>();
            for (String word : words) {
                set.add(word);
            }
            for (String word : words) {
                set.contains(word);
            }
            long endTime  =System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.size());
            System.out.println("BSTSet: " + time + " s");

            System.out.println();

            startTime = System.nanoTime();
            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }
            for (String word : words) {
                trie.contains(word);
            }
            endTime  =System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }

    }

}
