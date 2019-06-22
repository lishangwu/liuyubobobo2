/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/14 00:56
 */

package com4.AVLTree;

import AInterface.Map;
import com.Set.FileOperation;

import java.util.ArrayList;

public class AVLTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTreeMap() {
        root = null;
        size = 0;
    }

    private Node getNode(Node node, K key){
        if(node == null)
            return null;

        if(key.compareTo(node.key) == 0){
            return node;
        }else if(key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }else {
            return getNode(node.right, key);
        }
    }

    private int getHeight(Node node){
        if(node == null)
            return 0;
        return node.height;
    }

    // 判断是否是一颗二分搜索树
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if(keys.get(i - 1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }
    private void inOrder(Node node, ArrayList<K> keys) {
        if(node == null)
            return;
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    // 判断是否是一颗 平衡二叉树
    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node node) {
        if(node == null)
            return true;

        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1){
            System.out.println("balanceFactor : " + balanceFactor + " , "  +node.key);
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    public int getBalanceFactor(Node node){
        if(node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node rightRotate(Node node){
        if(node == null)
            return null;

        Node x = node.left;
        node.left = x.right;
        x.right = node;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    private Node leftRotate(Node node){
        if(node == null)
            return null;

        Node x = node.right;
        node.right = x.left;
        x.left = node;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        }else {
            node.value = value;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
//        if(Math.abs(balanceFactor) > 1)
//            System.out.println("unbalanced : " + balanceFactor);

        //平衡维护
        //LL
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);
        //RR
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);
        //LR
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //RL
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;

    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if(node == null)
            return null;

        Node retNode;
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            retNode = node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            retNode = node;
        }
        else {
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                retNode = rightNode;
            }else
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode = leftNode;
            }else {
                Node successor = minimum(node.right);
//            successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }

        }

        if(retNode == null)
            return null;

        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        int balanceFactor = getBalanceFactor(retNode);
//        if(Math.abs(balanceFactor) > 1)
//            System.out.println("unbalanced : " + balanceFactor);

        //平衡维护
        //LL
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
            return rightRotate(retNode);
        //RR
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
            return leftRotate(retNode);
        //LR
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
            node.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //RL
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            node.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;

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

    private Node minimum(Node node) {
        if(node.left == null){
            return node;
        }
//        node.left = minimum(node.left);
//        return node;
        return minimum(node.left);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args){

        ArrayList<String> words = new ArrayList<>();

        FileOperation.readFile("pride-and-Prejudice.txt", words);

        AVLTreeMap<String, Integer> map = new AVLTreeMap<>();
        for (String word : words) {
            if(map.contains(word)){
                map.set(word, map.get(word) + 1);
            }else {
                map.add(word, 1);
            }
        }

        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of of: " + map.get("of"));
        System.out.println("Frequency of the: " + map.get("the"));

        System.out.println("is BST : " + map.isBST());
        System.out.println("is Balance : " + map.isBalanced());

        for (String word : words) {
            map.remove(word);
            if(!map.isBST() || !map.isBalanced()){
                throw new RuntimeException("Error");
            }
        }
        System.out.println("is BST : " + map.isBST());
        System.out.println("is Balance : " + map.isBalanced());
    }
}
