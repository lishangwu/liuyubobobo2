/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 15:31
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {

    //二叉树中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        list = inorderTraversal(root, list);

        return list;

    }

    private List<Integer> inorderTraversal(TreeNode node, List<Integer> list) {
        if(node == null){
            return list;
        }

        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);

        return list;
    }

    public static void main(String[] args){

        String s = "";



    }


}

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }

}