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
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {

        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //查找元素p所对应的集合编号
    private int find(int p){
        if(p < 0 && p > id.length)
            throw new IllegalArgumentException("p is out if bound.");

        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p q所属的集合
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
