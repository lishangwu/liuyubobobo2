/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/21 13:59
 */

package com6.MaxHeap;

import java.util.Random;

public class Main2 {

    public static void main(String[] args){

        int n = 10;
        Integer[] arr = new Integer[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(100);
            System.out.print(num + ",");
            arr[i] = num;
        }
        System.out.println();
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        MinHeap<Integer> minHeap = new MinHeap<>();
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            minHeap.add(arr[i]);
        }

        maxHeap.print();
        minHeap.print();
//
//        Array<Integer> a = new Array<>();
//        for (int i = 0; i < 10; i++) {
//            a.addLast(i);
//        }
//        System.out.println(a);
//        a.swap(9,0);
//        System.out.println(a);

    }

}
