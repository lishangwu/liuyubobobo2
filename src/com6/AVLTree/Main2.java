/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/26 18:36
 */

package com6.AVLTree;

import com.Set.FileOperation;

import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args){

        ArrayList<String> words = new ArrayList<>();

        FileOperation.readFile("pride-and-Prejudice.txt", words);

        AVLSet<String> avlSet = new AVLSet<>();
        for (String word : words) {
            avlSet.add(word);
        }
        System.out.println(avlSet.getSize());

    }

}
