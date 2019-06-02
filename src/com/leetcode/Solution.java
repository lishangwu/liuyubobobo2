/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/25 03:42
 */

package com.leetcode;

import java.util.Stack;

/**
 * Created by robin on 2019/1/25.
 */

public class Solution {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(c == ')' || c == ']' || c == '}'){
                if(c == ')'){
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
                if(c == ']'){
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
                if(c == '}'){
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if(stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if(topChar == ')' && topChar != '(')
                    return false;
                if(topChar == ']' && topChar != '[')
                    return false;
                if(topChar == '}' && topChar != '{')
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){

        System.out.println(new Solution().isValid("{{{}}}"));

    }


}
