/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/26 04:18
 */

package com.test;

/**
 * Created by robin on 2019/1/26.
 */
public class Sum {

    public static int sum(int[] arr){
        return sum(arr, 0 );
    }
    public static int sum(int[] arr, int l){
        if(l == arr.length)
            return 0;
        System.out.println(l);
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args){
        
        int[] arr = {1,2,3,4,5};

        System.out.println(Sum.sum(arr, 0));

    }

}
