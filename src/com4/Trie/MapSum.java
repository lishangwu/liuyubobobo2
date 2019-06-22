/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/14 00:18
 */

package com4.Trie;

import java.util.TreeMap;

/**
 *实现一个 MapSum 类里的两个方法，insert 和 sum。

 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。

 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。

 示例 1:

 输入: insert("apple", 3), 输出: Null
 输入: sum("ap"), 输出: 3
 输入: insert("app", 2), 输出: Null
 输入: sum("ap"), 输出: 5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/map-sum-pairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class MapSum {

    private class Node{
        public int val;
        public TreeMap<Character, Node> next;

        public Node(int val) {
            this.val = val;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    public void insert(String key, int val){
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }else {
                cur = cur.next.get(c);
            }
        }
        cur.val = val;

    }

    public int sum(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return 0;
            }else {
                cur = cur.next.get(c);
            }
        }

        return 0;
    }

    public int sum(Node node){
        int res = node.val;
        for (Character c : node.next.keySet()) {
            res = res + sum(node.next.get(c));
        }
        return res;
    }


    public static void main(String[] args){
        

                
    }

}
