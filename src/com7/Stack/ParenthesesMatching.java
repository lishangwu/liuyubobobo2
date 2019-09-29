/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/29 19:16
 */

package com7.Stack;
import java.util.Stack;

public class ParenthesesMatching {

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
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){

        String s = "({{}}{}[])";
        System.out.println(isValid(s));

    }

}
