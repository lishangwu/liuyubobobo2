/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 15:31
 */

package leetcode;

import java.util.*;

public class Solution347 {

    private class Freq implements Comparable<Freq>{
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {

            //低的往上
            if(this.freq > o.freq){
                return 1;
            }else if(this.freq < o.freq){
                return -1;
            }

            return 0;
        }
    }

    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }

        //java自带的优先队列：默认是最小堆
        PriorityQueue<Freq> pq = new PriorityQueue<>();

        for (Integer key : map.keySet()) {
            if(pq.size() < k){
                pq.offer(new Freq(key, map.get(key)));
            }else if(map.get(key) > pq.peek().freq){
                pq.poll();
                pq.offer(new Freq(key, map.get(key)));
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll().e);
        }

        return res;

    }
//
//    public List<Integer> topKFrequent2(int[] nums, int k) {
//
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for (int num : nums) {
//            if(map.containsKey(num)){
//                map.put(num, map.get(num) + 1);
//            }else {
//                map.put(num, 1);
//            }
//        }
//
//        //java自带的优先队列：默认是最小堆
//        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return map.get(a) - map.get(b);
//            }
//        });
//
//        for (Integer key : map.keySet()) {
//            if(pq.size() < k){
//                pq.offer(key);
//            }else if(map.get(key) > pq.peek()){
//                pq.poll();
//                pq.offer(key);
//            }
//        }
//
//        List<Integer> res = new LinkedList<>();
//        while (!pq.isEmpty()){
//            res.add(pq.poll());
//        }
//
//        return res;
//
//    }


    public static void main(String[] args){

        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(new Solution347().topKFrequent(nums, k));



    }


}


