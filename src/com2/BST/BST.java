/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/2/23 01:15
 */

package com2.BST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by robin on 2019/2/23.
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
        root = add(root, e);
    }

    private Node add(Node node, E e) {

        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

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
            System.out.println(cur.getClass());

            if(cur.left != null)
                q.add(cur.left);
            if(cur.right != null)
                q.add(cur.right);
        }
    }

    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty.");

        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    public E maxmum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty.");

        return maxmum(root).e;
    }

    private Node maxmum(Node node) {
        if(node.right == null)
            return node;
        return minimum(node.right);
    }

    //删除最小值所在节点,返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

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

    }

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

}
