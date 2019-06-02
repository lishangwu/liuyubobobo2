/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/29 00:04
 */

package com.test;

/**
 * Created by robin on 2019/1/29.
 */
public class Reverse {

    public int reverse(int x) {

//        int temp = Math.abs(x);
//        String str = Integer.toString(temp);
//        StringBuffer sb = new StringBuffer(str);
//        String res = sb.reverse().toString();
//        if( Long.parseLong(res) > Integer.MAX_VALUE )
//            res = "0";
//
//        return x > 0 ? Integer.parseInt(res) : -Integer.parseInt(res);
//
//

        int res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            System.out.println(res);
            x = x / 10;
            System.out.println(x);
        }
        return x > 0 ? res : -res;
    }

    public static void main(String[] args){

        System.out.println(new Reverse().reverse(123456789));

    }

}
