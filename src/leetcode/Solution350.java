/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 15:31
 */

package leetcode;

import java.util.*;

public class Solution350 {


    //交集
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i : nums1) {
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else {
                map.put(i, map.get(i) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if(map.containsKey(i)){
                list.add(i);
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0){
                    map.remove(i);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    
    public static void main(String[] args){

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println(new Solution350().intersection(nums1, nums2));

    }


}


