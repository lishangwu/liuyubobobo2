/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/22 19:22
 */

package com5.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> implements AInterface.BST<E> {

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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E e) {
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

    @Override
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
        else
            return true;
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if(root == null)
            return;

        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
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

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }

    @Override
    public void levelOrder() {
        Queue<Node> q = new LinkedList();
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

    @Override
    public E minimum() {
        if(isEmpty())
            throw new IllegalArgumentException("BST is empty");

        return minimum(root).e;
    }

    private Node minimum(Node node) {
        return node.left == null ? node : minimum(node.left);
    }

    @Override
    public E maxmum() {
        if(isEmpty())
            throw new IllegalArgumentException("BST is empty");

        return maxmum(root).e;
    }

    private Node maxmum(Node node) {
        return node.right == null ? node : maxmum(node.right);
    }

    @Override
    public E removeMin() {
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

    @Override
    public E removeMax() {
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

    @Override
    public void remove(E e) {
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
        }else {
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
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
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
