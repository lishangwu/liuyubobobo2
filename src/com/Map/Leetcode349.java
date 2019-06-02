/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/28 04:38
 */

package com.Map;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by robin on 2019/1/28.
 *
 * 给定两个数组，编写一个函数来计算它们的交集。

 示例 1:

 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2]
 示例 2:

 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [9,4]
 * 说明:

 输出结果中的每个元素一定是唯一的。
 我们可以不考虑输出结果的顺序。
 */
public class Leetcode349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
    
    public static void main(String[] args){
        
        int[] nums1 = {1,3,4,5,6,7,7,8};
        int[] nums2 = {2,3,3,4,6};
        int[] inter = new Leetcode349().intersection(nums1,nums2);
        for (int i : inter) {
            System.out.println(i);
        }
                
    }


}
