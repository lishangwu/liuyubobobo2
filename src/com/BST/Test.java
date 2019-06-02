/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/27 03:39
 */

package com.BST;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by robin on 2019/1/27.
 */
public class Test {

    public static void main(String[] args){
        
        BST<Integer> bst = new BST<>();
//        int[] nums = {5,3,6,8,4,2};
//        for(int num : nums)
//            bst.add(num);

//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();
//        System.out.println();
//        bst.levelOrder();

//        bst.hasPathSum(12);

//        System.out.println(bst);


        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMax());

        System.out.println(nums);

        for (int i=1; i<nums.size(); i++)
            if(nums.get(i-1) < nums.get(i))
                throw new IllegalArgumentException("error");

        System.out.println("removeMin test completed.");

    }

}
