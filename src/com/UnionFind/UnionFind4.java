/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/31 17:31
 */

package com.UnionFind;

/**
 * Created by robin on 2019/1/31.
 */
public class UnionFind4 implements UF {

    private int[] parent;
    private int[] rank; // rand[i] 以i为根的集合中元素个数

    public UnionFind4(int size) {

        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查找元素p所对应的集合编号
    private int find(int p){
        if(p < 0 && p > parent.length)
            throw new IllegalArgumentException("p is out if bound.");

        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p q所属的集合
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        }else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }


}
