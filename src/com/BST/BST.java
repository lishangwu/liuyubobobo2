/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/27 03:00
 */

package com.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by robin on 2019/1/27.
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
//        if(root == null){
//            root = new Node(e);
//            size ++;
//        }else{
//            add(root, e);
//        }
        root = add2(root, e);
    }

    private void add(Node node, E e){
        if(e.equals(node.e))
            return;
        else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        }
        else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }

        if(e.compareTo(node.e) < 0)
            add(node.left, e);
        else
            add(node.right, e);

    }

    private Node add2(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add2(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add2(node.right, e);

        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    //二分搜索树 前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }

    }

    //mid
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //hou
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null)
                q.add(cur.left);
            if(cur.right != null)
                q.add(cur.right);
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if(node.left == null)
            return  node;
        return minimum(node.left);
    }

    public E maxmum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maxmum(root).e;
    }

    private Node maxmum(Node node) {
        if(node.right == null)
            return node;
        return maxmum(node.right);
    }

    //删除最小值所在节点,返回最小值
    public E removeMin(){
        E ret = minimum();

        root = removeMin(root);

        return ret;
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E ret = maxmum();

        root = removeMax(root);

        return ret;
    }

    private Node removeMax(Node node) {
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    //删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if(node == null)
            return null;

        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else{// e == node.e
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            //节点左右子树都不为空
            //找到比待删除节点大的最小节点,即待删除节点有子树的最小节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    //
    public boolean hasPathSum(int sum){
        StringBuilder res = new StringBuilder();
        return root != null && findPathSum(root, sum, res);
    }

    private boolean findPathSum(Node node, int sum, StringBuilder res) {

        if(node == null)
            return false;

        sum = sum - (Integer) node.e;
        res.append(node.e + "->");
        if(sum == 0 && node.left == null && node.right == null){
            System.out.println(res);
            return true;
        }

        return findPathSum(node.left, sum, res) || findPathSum(node.right, sum, res);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTSring(root, 0 , res);
        return res.toString();
    }

    private void generateBSTSring(Node node, int depth, StringBuilder res) {
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTSring(node.left, depth + 1, res);
        generateBSTSring(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
