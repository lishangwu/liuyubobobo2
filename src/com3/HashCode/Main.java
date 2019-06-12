/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/11 16:50
 */

package com3.HashCode;

public class Main {

    public static void main(String[] args){
        
        int a = 42;
        System.out.println(((Integer) a).hashCode());

        int b = -42;
        System.out.println(((Integer) b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double) c).hashCode());

        System.out.println("imooc".hashCode());

    }

}
