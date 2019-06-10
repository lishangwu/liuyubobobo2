/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/9 12:33
 */

package com3.SegmentTree;

/*
* New
给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。

示例:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
说明:

数组仅可以在 update 函数下进行修改。
你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
* */
public class NumArray307 {

    private int[] sum; // sum[i]存储前i个元素和
                        // sun[i] : [0...i-1]的和

    private int[] data;

    public NumArray307(int[] nums) {

//        this.nums = nums;
        this.data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.data[i] = nums[i];
        }

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

    }

    public void update(int index, int val) {
        this.data[index] = val;

        for (int i = index + 1; i < data.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}
