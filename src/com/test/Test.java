/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/3/28 04:41
 */

package com.test;

public class Test {

//    public int aMethod() {
//        static int i=0;
//        i++;
//        return i;
//    }
    public static void main(String args[]) {
        int i = 9 ;
        switch(i) {
            default:
                System.out.println("default");
            case 0 :
                System.out.println("zero");
                break ;
            case 1 : System.out.println("one");
            case 2 : System.out.println("two");
        }
    }

}
