/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 15:31
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution349 {


    //交集
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if(set.contains(i)){
                list.add(i);
                set.remove(i);
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

        System.out.println(new Solution349().intersection(nums1, nums2));

    }


}


