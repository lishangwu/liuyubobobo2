/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 15:31
 */

package leetcode;

import java.util.Stack;

public class Solution {

    public static boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(c == ')' && topChar != '('){
                    return false;
                }
                if(c == ']' && topChar != '['){
                    return false;
                }
                if(c == '}' && topChar != '{'){
                    return false;
                }
            }
        }

        //此时栈底是否还有元素,有：匹配失败
        return stack.isEmpty();

    }

    public static void main(String[] args){

        String s = "";

        System.out.println(isValid(s));


    }


}
