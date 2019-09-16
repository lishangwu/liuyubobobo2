/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/22 19:13
 */

package com5.Linked;

public class RemoveElements {


    public ListNode removeElements2(ListNode head, int val){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;

        while (pre.next != null){
            if(pre.next.val == val)
                pre.next = pre.next.next;
            else
                pre = pre.next;
        }

        return dummyHead.next;
    }

    public ListNode removeElements3(ListNode head, int val){
        if(head == null)
            return null;

        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }



    public static void main(String[] args){

        int[] nums = {1,2,6,3,4,5,6};

        ListNode head = new ListNode(nums);

        System.out.println(head);

        System.out.println(new RemoveElements().removeElements2(head, 6));

    }

}
