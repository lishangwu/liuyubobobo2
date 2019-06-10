/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/9 13:45
 */

package com3.Trie;

import com.Set.FileOperation;
import com3.Set.BSTSet;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("A-Tale-of-Two-Cities2.txt", words)){

            System.out.println("words : " + words.size());

            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();
            for (String word : words) {
                set.add(word);
            }
            for (String word : words) {
                set.contains(word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");

            // ---
            startTime = System.nanoTime();

            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }
            for (String word : words) {
                trie.contains(word);
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }

    }

}
