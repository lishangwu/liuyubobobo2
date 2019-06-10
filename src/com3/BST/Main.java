/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/6 11:59
 */

package com3.BST;

public class Main {

    public static void main(String[] args){
        
        BST_2<Integer> bst = new BST_2<>();

//        Random random = new Random();
//        int n = 1000;
//
//        for (int i = 0; i < n; i++) {
//            bst.add(random.nextInt(10000));
//        }
//
//        List<Integer> list = new ArrayList<>();
//        while (!bst.isEmpty()){
//            list.add(bst.removeMax());
//        }
//
//        System.out.println(list);
//
//        for (int i = 1; i < list.size(); i++) {
////            if(list.get(i - 1) > list.get(i)){
////                throw new IllegalArgumentException("Error");
////            }
//            if(list.get(i - 1) < list.get(i)){
//                throw new IllegalArgumentException("Error");
//            }
//        }
//
//        System.out.println("removeMin test completed.");

        int[] nums = {5, 2, 3,4,1 ,6,8,9};
        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrder();
        System.out.println();
        bst.remove(3);
        bst.preOrder();

    }

}
