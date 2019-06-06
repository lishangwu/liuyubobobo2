/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 15:31
 */

package leetcode;

public class Solution203 {

    public ListNode removeElements(ListNode head, int val){

        while (head != null && head.val == val){
            head = head.next;
        }

        if(head == null){
            return head;
        }

        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }

        return head;

    }
    //删除 链表 中的元素,
    public ListNode removeElements2(ListNode head, int val){

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;

        while (prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public ListNode removeElements3(ListNode head, int val){

        if(head == null)
            return null;

        head.next = removeElements3(head.next, val);
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
//        return head.val == val ? head.next : head;

    }
    
    public static void main(String[] args){
        
        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(arr);

        System.out.println(head);

        System.out.println(new Solution203().removeElements3(head, 3));

    }


}


