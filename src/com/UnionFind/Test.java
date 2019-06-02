/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/31 17:54
 */

package com.UnionFind;

import java.util.Random;

/**
 * Created by robin on 2019/1/31.
 */
public class Test {

    private static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){
        
        int size = 10000000;
        int m = 10000;

//        UnionFind1 u1 = new UnionFind1(size);
//        System.out.println(testUF(u1, m));
//
//        UnionFind2 u2 = new UnionFind2(size);
//        System.out.println(testUF(u2, m));

        UnionFind2 u3 = new UnionFind2(size);
        System.out.println(testUF(u3, m));

        UnionFind2 u4 = new UnionFind2(size);
        System.out.println(testUF(u4, m));

        UnionFind2 u5 = new UnionFind2(size);
        System.out.println(testUF(u5, m));

        UnionFind2 u6 = new UnionFind2(size);
        System.out.println(testUF(u6, m));

    }

}
