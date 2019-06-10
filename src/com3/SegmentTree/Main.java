/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/9 11:55
 */

package com3.SegmentTree;

import com.SegmentTree.Merger;

public class Main {

    public static void main(String[] args){
        
//        Integer[] nums = {-2, 0, -5, 2, -1};
        Integer[] nums = {1,2,3,4,5,6,7,8,9};

        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });

//        SegmentTree<Integer> segmentTree2 = new SegmentTree<>(nums, (a, b) -> a + b);


        System.out.println(segmentTree);

//        System.out.println(segmentTree.query(0, 3));
        System.out.println(segmentTree.query(3, 5));

    }

}
