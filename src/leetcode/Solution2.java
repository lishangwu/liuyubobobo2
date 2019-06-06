/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 22:11
 */

package leetcode;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead1 = new ListNode(-1);
        dummyHead1.next = l1;
        ListNode dummyHead2 = new ListNode(-1);
        dummyHead2.next = l2;

        ListNode prev1 = dummyHead1, prev2 = dummyHead2;

        String str1 = "";
        while (prev1.next != null){
            str1 = prev1.next.val + str1;
            prev1 = prev1.next;
        }
        String str2 = "";
        while (prev2.next != null){
            str2 = prev2.next.val + str2;
            prev2 = prev2.next;
        }

        String str =  (Long.valueOf(str1) + Long.valueOf(str2)) + "";

        ListNode head = new ListNode( Integer.valueOf(str.charAt(str.length() - 1) + "") );
        ListNode cur = head;
        for (int i = str.length() - 2; i >= 0; i--) {
            cur.next = new ListNode( Integer.valueOf(str.charAt(i) + "") );
            cur = cur.next;
        }

        return head;
    }
    
    public static void main(String[] args){

        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};

        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
        System.out.println(l1);
        System.out.println(l2);

        System.out.println(new Solution2().addTwoNumbers(l1 ,l2));

    }

}

