/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/21 15:16
 */

package com6.MaxHeap;

import java.util.LinkedList;
import java.util.List;
//import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {

    public class Freq implements Comparable<Freq>{
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if(this.freq < o.freq){
                return 1;
            }else if(this.freq > o.freq) {
                return -1;
            }else {
                return 0;
            }
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

        for (Integer key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if(pq.getSize() < k){
                pq.enqueue(new Freq(key, map.get(key)));
            }else if(map.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()){
            res.add(pq.dequeue().e);
        }
        return res;
    }

    public static void main(String[] args){

        int[] arr = {1,1,1,1,2,3,4,4,5,6,6,7};

        System.out.println(new Solution().topKFrequent(arr, 2));
    }

}
