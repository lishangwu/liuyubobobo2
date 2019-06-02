/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/3/28 03:34
 */

package com.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class DoubleDimensionalArray {

    public boolean Find(int target, int [][] array) {
        long start = System.nanoTime();
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < array.length; i++) {

            int arr[] = array[i];

            for (int i1 = 0; i1 < arr.length; i1++) {
                set.add(arr[i1]);
            }
        }
        long end = System.nanoTime();

        System.out.println("Find : " + (end - start));
        return set.contains(target);

    }

    public boolean Find2(int target, int [][] array){

        long start = System.nanoTime();
        int rows = array.length;
        int columns = array[0].length;

        if(array != null && rows > 0 && columns > 0){

            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0){
                if(array[row][column] == target){
                    long end = System.nanoTime();
                    System.out.println("Find2 : " + (end - start));
                    return true;
                }else if(array[row][column] > target){
                    column --;
                }else {
                    row ++;
                }
            }

        }


        return false;
    }

    public static void toSet(int [][] array) {

        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < array.length; i++) {

            int arr[] = array[i];

            for (int i1 = 0; i1 < arr.length; i1++) {
                set.add(arr[i1]);
            }
        }

        for (Integer integer : set) {
            System.out.print(" ");
            System.out.print(integer);

        }
        System.out.println();

    }
    
    public static void main(String[] args){

        int [][] array = new int[1000][1000];

        for (int i = 0; i < array.length; i++) {

            int ints[] = new int[array[i].length];
            if(i >= 1){
                for (int j = array[i-1][0] + 1; j < ints.length; j++) {
                    ints[j] = j;
                }
            }else{
                for (int j = 0; j < ints.length; j++) {
                    ints[j] = j;
                }
            }

            array[i] = ints;
        }

        System.out.println(new DoubleDimensionalArray().Find(995, array));
        System.out.println(new DoubleDimensionalArray().Find2(995, array));


    }




}
