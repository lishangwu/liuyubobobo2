/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 15:31
 */

package leetcode;

public class Solution876 {


    public ListNode middleNode(ListNode head) {

        if(head == null && head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            if(fast.next == null) break;
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null){
                fast = fast.next;
            }
            System.out.println(slow.val + " : " + fast.val);
        }

        return slow;
    }

    
    public static void main(String[] args){
        
        int[] arr = {1,2,3,4,5,6,7,8, 9};
        int[] arr2 = {1,2,3,4,5,6,7,8};
        ListNode head = new ListNode(arr);
        ListNode head2 = new ListNode(arr2);

        System.out.println(head);
        System.out.println(head2);

        System.out.println(new Solution876().middleNode(head));
        System.out.println(new Solution876().middleNode(head2));

    }


}


