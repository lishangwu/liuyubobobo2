/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 22:11
 */

package leetcode;

/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
* */

import java.util.Arrays;

public class Solution16 {


    //三个
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int sub = 0;
        int abssub = 0;
        int sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int left = 0, right = nums.length - 1;

            while (left < i && right > i){
                sub = nums[left] + nums[right] + nums[i] - target;
                abssub = Math.abs(sub);
                if(diff > abssub){
                    diff = abssub;
                    sum = nums[left] + nums[right] + nums[i];
                }
                if(sub > 0) right --;
                else if(sub < 0) left ++;
                else {
                    sum = nums[left] + nums[right] + nums[i];
                    break;
                }
            }
        }

        return sum;

    }

    
    public static void main(String[] args){

        int[] arr = {-1, 2, 1,-4};
        int[] arr2 = {1,1,1,0};
        int[] arr3 = {1,2,9,3,4,5,6};

        int[] arr4 = {0,2,1,-3};

        System.out.println(new Solution16().threeSumClosest(arr, 1));

//        System.out.println(new Solution16().threeSumClosest(arr2, 100));

    }

}

