/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/30 02:53
 */

package com7.RedBlackTree;

import AInterface.Map;

public class RBMap<K extends Comparable<K>, V> implements Map<K, V> {

    private RBTree<K, V> rbTree;

    public RBMap() {
        rbTree = new RBTree<>();
    }

    @Override
    public void add(K key, V value) {
        rbTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return rbTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return rbTree.contains(key);
    }

    @Override
    public V get(K key) {
        return rbTree.get(key);
    }

    @Override
    public void set(K key, V value) {
        rbTree.set(key, value);
    }

    @Override
    public int getSize() {
        return rbTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return rbTree.isEmpty();
    }
}
