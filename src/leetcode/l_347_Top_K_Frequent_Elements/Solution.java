/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/21 15:48
 */

package leetcode.l_347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution {

    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if (this.freq < o.freq)
                return -1;
            else if (this.freq > o.freq)
                return 1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //java默认最小堆
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else {
                if (map.get(key) > pq.peek().freq) {
                    pq.remove();
                    pq.add(new Freq(key, map.get(key)));
                }
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 2, 3, 4, 4, 5, 6, 6, 7};

        System.out.println(new Solution().topKFrequent(arr, 2));
    }

}
