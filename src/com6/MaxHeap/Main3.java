/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/21 14:56
 */

package com6.MaxHeap;

import java.util.Random;

public class Main3 {

    public static void findMin_M(int[] arr, int m){
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < m; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i = m; i < arr.length; i++) {
            int max = maxHeap.findMax();
            if(max > arr[i]){
                maxHeap.replace(arr[i]);
            }
        }
        maxHeap.print();
    }

    public static void findMax_M(int[] arr, int m){
        MinHeap<Integer> minHeap = new MinHeap<>();
        for (int i = 0; i < m; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = m; i < arr.length; i++) {
            int min = minHeap.findMin();
            if(min < arr[i]){
                minHeap.replace(arr[i]);
            }
        }
        minHeap.print();
    }

    public static void main(String[] args){
        int n = 10000;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(n);
            arr[i] = num;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        findMin_M(arr, 2);
        findMax_M(arr, 2);
    }

}
