/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/30 02:12
 */

package com.SegmentTree;

/**
 * Created by robin on 2019/1/30.
 */
public class Test {

    public static void main(String[] args){
        
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });

        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 2));

    }

}
