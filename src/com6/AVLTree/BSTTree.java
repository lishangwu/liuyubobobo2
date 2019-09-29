/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/26 12:18
 */

package com6.AVLTree;

import AInterface.Map;
import com.Set.FileOperation;

import java.util.ArrayList;

public class BSTTree<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTTree() {
        root = null;
        size = 0;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimun(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.right = node.left = null;
            return successor;
        }
//        return node;
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

    private Node minimun(Node node) {
        if (node.left == null)
            return node;
        return minimun(node.left);
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
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
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

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.key + ":" + node.value);
        inOrder(node.right);
    }

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>();

        FileOperation.readFile("pride-and-Prejudice.txt", words);

        ArrayList<String> words2 = new ArrayList<>();
        for (int i = 0; i < words.size() / 20; i++) {
            words2.add(words.get(i));
        }
        words = words2;

//        Collections.sort(words);

        BSTTree<String, Integer> bstTree = new BSTTree<>();

        for (String word : words) {
            word = word.trim();
            if (bstTree.contains(word)) {
                bstTree.set(word, bstTree.get(word) + 1);
            }else {
                bstTree.add(word, 1);
            }
        }

        for (String word : words) {
            word = word.trim();
            bstTree.remove(word);
        }

        bstTree.inOrder();

        System.out.println();
        System.out.println("words.size: " + words.size());
        System.out.println("Total different words: " + bstTree.getSize());
        System.out.println("Frequency of of: " + bstTree.get("out"));
        System.out.println("Frequency of the: " + bstTree.get("the"));
    }
}
