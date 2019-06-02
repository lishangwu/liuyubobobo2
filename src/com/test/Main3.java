/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/2/2 02:20
 */

package com.test;

/**
 * Created by robin on 2019/2/2.
 */
public class Main3 {

    public static int firstUniqChar(String s){

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args){

        System.out.println(firstUniqChar("lletcode"));


    }

}
