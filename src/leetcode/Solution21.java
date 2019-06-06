/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 22:11
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead1 = new ListNode(-1);
        dummyHead1.next = l1;
        ListNode dummyHead2 = new ListNode(-1);
        dummyHead2.next = l2;

        ListNode prev1 = dummyHead1, prev2 = dummyHead2;

        List<Integer> list = new ArrayList<>();

        while (prev1.next != null){
            list.add(prev1.next.val);
            prev1 = prev1.next;
        }
        while (prev2.next != null){
            list.add(prev2.next.val);
            prev2 = prev2.next;
        }

        if(list.size() == 0){
            return null;
        }

        Collections.sort(list);

        ListNode head = new ListNode( list.get(0) );
        ListNode cur = head;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }

        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);

        ListNode prev = dummyHead;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if(l1 != null){
            prev.next = l1;
        }
        if(l2 != null){
            prev.next = l2;
        }

        return dummyHead.next;
    }

    
    public static void main(String[] args){

        int[] arr1 = {1,2,4};
        int[] arr2 = {1,3,4};

        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
        System.out.println(l1);
        System.out.println(l2);

        System.out.println(new Solution21().mergeTwoLists2(l1 ,l2));

    }

}

