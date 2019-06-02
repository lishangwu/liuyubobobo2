/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/28 03:50
 */

package com.Map;

import com.Set.FileOperation;

import java.util.ArrayList;

/**
 * Created by robin on 2019/1/28.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
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

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else
            node.value = value;

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

        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }
        else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
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

            Node successor = minmun(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
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

    private Node minmun(Node node) {
        if(node.left == null)
            return node;
        return minmun(node.left);
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
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exists!");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public Node getNode(Node node, K key){
        if(node == null)
            return null;

        if(key.compareTo(node.key) == 0)
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    public static void main(String[] args){

        ArrayList<String> words = new ArrayList<>();

        FileOperation.readFile("A-Tale-of-Two-Cities.txt", words);
        words.add("hello");
        words.add("sb");
        words.add("hello");
        words.add("hello");
        words.add("hello");
        words.add("hh");
        words.add("hello");
        words.add("ok");
        words.add("hello");
        words.add("hello");
        words.add("ok");
        words.add("hello");
        words.add("hello");
        words.add("hello");
        words.add("hello");



        System.out.println("Total words: " + words.size());

        BSTMap<String, Integer> map = new BSTMap<>();
        for (String word : words) {
            if(map.contains(word)){
                map.set(word, map.get(word) + 1);
            }else{
                map.add(word, 1);
            }
        }

        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of ok: " + map.get("ok"));
        System.out.println("Frequency of hello: " + map.get("hello"));

    }
}
