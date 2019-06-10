/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/8 00:28
 */

package com3.Set;

import com3.BST.BST_2;

public class BSTSet<E extends Comparable<E>> implements AInterface.Set<E> {


    private BST_2<E> bst;

    public BSTSet() {
        this.bst = new BST_2<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
