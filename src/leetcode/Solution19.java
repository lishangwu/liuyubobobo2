/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 22:11
 */

package leetcode;

public class Solution19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return head;
        }

        int length = 1;
        ListNode p = head;
        while (p.next != null){
            p = p.next;
            length ++;
        }

        int th = length - n + 1;
        if(th < 0){
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        int count = 0;
        while (prev.next != null){
            count ++;
            if(count == th){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }

        return dummyHead.next;

    }

    
    public static void main(String[] args){

        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(arr);

        System.out.println(head);

        System.out.println(new Solution19().removeNthFromEnd(head, 2));

    }

}

