/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/29 05:15
 */

package com.MaxHeap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by robin on 2019/1/29.
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]
 说明：

 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Leetcode347 {

    private class Freq implements Comparable<Freq>{
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if(this.freq < o.freq)
                return 1;
            else if(this.freq > o.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else
                map.put(num, map.get(num) + 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key: map.keySet()){
            if(pq.getSize() < k)
                pq.enqueue(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (!pq.isEmpty())
            list.add(pq.dequeue().e);

        return list;
    }

}
