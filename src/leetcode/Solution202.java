/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 15:31
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;

//输入: 19
//输出: true
//        解释:
//        1^2 + 9^2 = 82
//        8^2 + 2^2 = 68
//        6^2 + 8^2 = 100
//        1^2 + 0^2 + 0^2 = 1
public class Solution202 {

    //正整数
    public boolean isHappy(int n) {

        if(n < 1){
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int temp, newN;

        while (n != 1 && !set.contains(n)){
            set.add(n);
            newN = 0;
            while (n>0){
                temp = n % 10;
                n = n / 10;
                newN = newN + temp * temp;
            }
            n = newN;
        }

        return n == 1;
    }

    public static void main(String[] args){
        
        System.out.println(new Solution202().isHappy(1229));

    }


}


