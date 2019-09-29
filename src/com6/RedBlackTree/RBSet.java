/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/27 01:20
 */

package com6.RedBlackTree;

import AInterface.Set;

public class RBSet<E extends Comparable<E>> implements Set<E> {

    private RBTree2<E> rbTree;

    public RBSet() {
        rbTree = new RBTree2<>();
    }

    @Override
    public void add(E e) {
        rbTree.add(e);
    }

    @Override
    public void remove(E e) {
        rbTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return rbTree.contains(e);
    }

    @Override
    public int getSize() {
        return rbTree.size();
    }

    @Override
    public boolean isEmpty() {
        return rbTree.isEmpty();
    }
}
