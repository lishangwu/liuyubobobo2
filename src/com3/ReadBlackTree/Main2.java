/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/11 14:12
 */

package com3.ReadBlackTree;

import AInterface.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2 {

    public static double test(Map<Integer, Integer> map, List<Integer> list){

//        Collections.sort(words);

        long startTime = System.nanoTime();


        for (Integer x : list) {
            map.add(x, null);
        }

        for (Integer x : list) {
            map.contains(x);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){
        
        int n = 2000 * 1000;
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(Integer.MAX_VALUE));
        }

//        Map<Integer, Integer> bst = new BSTMap<>();
//        Map<Integer, Integer> avl = new AVLMap<>();
        Map<Integer, Integer> rb  = new RBTree<>();

//        System.out.println(test(bst, list));
//        System.out.println(test(avl, list));
        System.out.println(test(rb, list));


    }

}
