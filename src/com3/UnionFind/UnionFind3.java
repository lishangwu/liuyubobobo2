/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/9 19:28
 */

package com3.UnionFind;

public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }

    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查看元素p 所对应的集合编号
    private int find(int p){

        if(p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is put of bound");

        while (p != parent[p]){
            p = parent[p];
        }

        return p;
    }

    //查看元素p和q是否所属一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pROOT = find(p);
        int qROOT = find(q);

        if(pROOT == qROOT)
            return;

        if(sz[pROOT] < sz[qROOT]){
            parent[pROOT] = qROOT;
            sz[pROOT] += sz[pROOT];
        }else {
            parent[qROOT] = pROOT;
            sz[qROOT] += sz[qROOT];
        }



    }


}
