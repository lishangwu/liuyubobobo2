package com.UnionFind;

/**
 * Created by robin on 2019/1/31.
 */
public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
