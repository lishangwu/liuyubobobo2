/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 15:31
 */

package leetcode;

import java.util.Stack;

public class Solution844 {


    public boolean backspaceCompare(String S, String T) {

        String s1 = backspace(S);
        String s2 = backspace(T);

        System.out.println(s1);
        System.out.println(s2);

        return s1.equals(s2);

    }

    public String backspace(String S){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            String ch = S.charAt(i) + "";
            if(stack.isEmpty() && !ch.equals("#")){
                stack.push(ch);
            }else{
                if(ch.equals("#")){
                    if(!stack.isEmpty())
                        stack.pop();
                }else {
                    stack.push(ch);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            res.append(stack.get(i));
        }

        return res.toString();
    }

    
    public static void main(String[] args){

        String S = "y#fo##f", T = "y#fo##f";
        System.out.println(new Solution844().backspaceCompare(S, T));

    }


}


