/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/24 17:08
 */

package com6.Trie;

import java.util.TreeMap;

public class Trie208 {

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    public Trie208() {
        root = new Node();
    }

    public void insert(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
        }
    }

    public boolean search(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
