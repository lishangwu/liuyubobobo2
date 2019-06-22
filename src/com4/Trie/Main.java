/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/14 00:12
 */

package com4.Trie;

import com.Set.FileOperation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("A-Tale-of-Two-Cities2.txt", words);

        System.out.println("words : " + words.size());

        long startTime = System.nanoTime();

        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        for (String word : words) {
            trie.contains(word);
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("Total different words: " + trie.getSize());
        System.out.println("Trie: " + time + " s");
    }

}
