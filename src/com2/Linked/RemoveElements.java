/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/2/23 00:54
 */

package com2.Linked;

/**
 * Created by robin on 2019/2/23.
 */
public class RemoveElements {

    public ListNode removeElement(ListNode head, int val){

        if(head == null)
            return null;

        while (head != null && head.val == val)
            head = head.next;

        ListNode pre = head;
        while (pre.next != null){
            if (pre.next.val == val)
                pre.next = pre.next.next;
            else
                pre = pre.next;
        }

        return head;
    }

    public ListNode removeElement2(ListNode head, int val){
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

    public ListNode removeElement3(ListNode head, int val){
        if(head == null)
            return null;

        head.next = removeElement3(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args){
        
        int arr[] = {1,2,3,4,5,6,7};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        System.out.println(new RemoveElements().removeElement2(head, 2));

    }
}
