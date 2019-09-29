/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/26 19:31
 */

package com6.RedBlackTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//红黑树基于二分搜索树
public class RBTree2<E extends Comparable<E>> {

    public static final boolean RED = true;
    public static final boolean BLACK = false;
    private class Node {
        public E e;
        public Node left, right;
        public boolean color;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree2() {
        root = null;
        size = 0;
    }

    private boolean isRed(Node node){
        return node == null ? BLACK : node.color;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node leftRotate(Node node){
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }
    private Node rightRotate(Node node){
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void add(E e) {
        root = add(root, e);
        root.color = BLACK;
    }

    private Node add(Node node, E e) {
        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }

        if(isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);

        if(isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);

        if(isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if(node == null)
            return false;

        if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else if(e.compareTo(node.e) > 0)
            return contains(node.right, e);
        return true;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //前序非递归方式
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

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder() {
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

    public E minimum() {
        if(size == 0)
            throw new IllegalArgumentException("BAT is empty");
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if(node.left == null)
            return node;

        return minimum(node.left);
    }

    public E maxmum() {
        if(size == 0)
            throw new IllegalArgumentException("BAT is empty");
        return maxmum(root).e;
    }

    private Node maxmum(Node node) {
        return node.right == null ? node : maxmum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if(node == null)
            return node;

        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else {
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }

    public boolean hasPathSum(int sum) {
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
