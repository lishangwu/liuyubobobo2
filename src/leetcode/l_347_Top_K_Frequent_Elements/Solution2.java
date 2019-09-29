/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/21 15:48
 */

package leetcode.l_347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution2 {

    private class Freq {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    private class FreqComparator implements Comparator<Freq> {

        @Override
        public int compare(Freq o1, Freq o2) {
            return o1.freq - o2.freq;
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
        PriorityQueue<Freq> pq = new PriorityQueue<>(k, new FreqComparator());
        for (Integer key : map.keySet()) {
            if(pq.size() < k){
                pq.add(new Freq(key, map.get(key)));
            }else {
                if(map.get(key) > pq.peek().freq){
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

        System.out.println(new Solution2().topKFrequent(arr, 2));
    }

}
