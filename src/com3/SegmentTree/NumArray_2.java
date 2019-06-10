/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/9 12:33
 */

package com3.SegmentTree;

/*
* 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

示例：

给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
说明:

你可以假设数组不可变。
会多次调用 sumRange 方法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-sum-query-immutable
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumArray_2 {

    private int[] sum; // sum[i]存储前i个元素和
                        // sun[i] : [0...i-1]的和

    public NumArray_2(int[] nums) {

        sum = new int[nums.length + 1];
        sum[0] = 0;

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}
