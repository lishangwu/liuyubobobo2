/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/21 14:16
 */

package com6.MaxHeap;

import java.util.Random;

public class Main {

    public static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify){
            maxHeap = new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for (Integer integer : testData) {
                maxHeap.add(integer);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extracMax();
        }
        for (int i = 1; i < testData.length; i++) {
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){

        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData, false);//O(nlogn)
        double time2 = testHeap(testData, true);//构造函数快  O(n)

        System.out.println(time1);
        System.out.println(time2);

    }

}
