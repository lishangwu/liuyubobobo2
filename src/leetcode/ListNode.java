/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 22:17
 */

package leetcode;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] arr) {
        if(arr == null || arr.length == 0){
            return;
        }
        //先定义一个head，从head往后加
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res=  new StringBuilder();

        res.append("");

        ListNode cur = this;
        while (cur != null){
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append(" Null ");

        return res.toString();
    }
}
