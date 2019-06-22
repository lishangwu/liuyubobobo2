/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/13 12:46
 */

package com4.MaxHeap;

import java.util.Random;

public class Main2 {

    public static void main(String[] args){

        int n = 1000000;

        Integer[] arr = new Integer[n];
        int n2 = 10;
        Integer[] arr2 = new Integer[n2];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(n);
            arr[i] = num;
            if(i<n2){
                arr2[i] = num;
            }
        }

        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i]);
        }

        System.out.println();

        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr2);
        MinHeap<Integer> minHeap = new MinHeap<>(arr2);

        //i =0 or i = 10;
        for (int i = 10; i < n; i++) {
            if(maxHeap.findMax() > arr[i]){
                maxHeap.replace(arr[i]);
            }
            if(minHeap.findMin() < arr[i]){
                minHeap.replace(arr[i]);
            }
        }

        maxHeap.print();
        minHeap.print();




    }

}

