/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/21 15:48
 */

package leetcode.l_347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution4 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //java默认最小堆
//        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return map.get(o1) - map.get(o2);
//            }
//        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a,b)->map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            if(pq.size() < k){
                pq.add(key);
            }else {
                if(map.get(key) > map.get(pq.peek())){
                    pq.remove();
                    pq.add(key);
                }
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 2, 3, 4, 4, 5, 6, 6, 7};

        System.out.println(new Solution4().topKFrequent(arr, 2));
    }

}
