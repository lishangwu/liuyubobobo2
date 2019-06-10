/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/9 19:28
 */

package com3.UnionFind;

public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        this.id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

    }

    @Override
    public int getSize() {
        return id.length;
    }

    //查看元素p 所对应的集合编号
    private int find(int p){
        if(p < 0 && p >= id.length)
            throw new IllegalArgumentException("p is put of bound");

        return id[p];
    }

    //查看元素p和q是否所属一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID)
            return;

        for (int i = 0; i < id.length; i++) {
            if(id[i] == pID)
                id[i] = qID;
        }
    }


}
