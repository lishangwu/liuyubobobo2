/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 22:11
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        Map<Integer, Integer> map = new HashMap();

        ListNode prev = dummyHead;
        while(prev.next != null){
            if(map.containsKey(prev.next.val)){
                map.put(prev.next.val, map.get(prev.next.val) + 1);
            }else{
                map.put(prev.next.val, 1);
            }
            prev = prev.next;
        }

        prev = dummyHead;
        while(prev.next != null){
            if(map.get(prev.next.val) > 1){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    //反转
    //输入: 1->2->3->4->5->NULL
    //输出: 5->4->3->2->1->NULL
    public ListNode reverseList(ListNode head) {
        ListNode first = head;
        ListNode reverseHead = null; //建立一个新的节点用来存放结果
        while (first != null) { //遍历输入链表，开始处理每一个节点
            ListNode second = first.next; //先处理第一个节点first，所以需要一个指针来存储first的后继
            first.next = reverseHead; //将first放到新链表头节点的头部
            reverseHead = first; //移动新链表的头指针，让它始终指向新链表头部
            first = second; //继续处理原链表的节点，即之前指针存放的后继，循环往复
        }
        return reverseHead;
    }
    
    public static void main(String[] args){

        int[] arr = {1,2,3,3,4,5,5,6,7,8,9};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        System.out.println(new Solution82().reverseList(head));

    }

}

