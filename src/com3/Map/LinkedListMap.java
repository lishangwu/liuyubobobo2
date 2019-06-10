/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/8 01:37
 */

package com3.Map;

import AInterface.Map;
import com.Set.FileOperation;

import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key) {
            this(key, null, null);
        }
        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.key.equals(key)){
                return cur;
            }else {
                cur = cur.next;
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key ,value, dummyHead.next);
            size ++;
        }else {
            node.value = value;
        }
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException(key + " doesn't exists");
        }else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next.key.equals(key)){
                break;
            }else {
                prev = prev.next;
            }
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }

        return null;
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

        System.out.println("Total words: " + words.size());

        Map<String, Integer> map = new LinkedListMap<>();
        for (String word : words) {
            if(map.contains(word)){
                map.set(word, map.get(word) + 1);
            }else{
                map.add(word, 1);
            }
        }

        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of ok: " + map.get("pride"));
        System.out.println("Frequency of hello: " + map.get("prejudice"));

    }
}
