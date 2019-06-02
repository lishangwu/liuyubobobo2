package com.SegmentTree;

/**
 * Created by robin on 2019/1/30.
 */
public interface Merger<E> {
    E merge(E a, E b);
}
