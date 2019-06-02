/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/2/23 00:53
 */

package com2.Linked;

/**
 * Created by robin on 2019/2/23.
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] arr) {
        if(arr == null || arr.length == 0)
            return;

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("");

        ListNode cur = this;
        while (cur != null){
            res.append(cur.val + "->");
            cur = cur.next;
        }

        res.append(" NULL ");
        return res.toString();
    }
}
