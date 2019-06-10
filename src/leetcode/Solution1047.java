/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/4 15:31
 */

package leetcode;

import java.util.Stack;

public class Solution1047 {

    //abbaca
    public String removeDuplicates(String S) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            String s = S.charAt(i) + "";
            if(!stack.isEmpty()){
                if(stack.peek().equals(s)){
                    stack.pop();
                }else {
                    stack.push(s);
                }
            }else{
                stack.push(s);
            }
        }

        StringBuilder res = new StringBuilder();
        for (Object o : stack.toArray()) {
            res.append(o.toString());
        }

        return res.toString();
    }

    
    public static void main(String[] args){

        String S = "abbaca";
        System.out.println(new Solution1047().removeDuplicates(S));



    }


}


