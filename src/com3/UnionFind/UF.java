/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/9 19:26
 */

package com3.UnionFind;

public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);

}
