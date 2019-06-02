/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/1/28 02:30
 */

package com.Set;

import java.util.TreeSet;

/**
 * Created by robin on 2019/1/28.
 */
public class Leetcode804 {

    public int uniqueMorseRepresentations(String[] words){
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> set = new TreeSet<>();
        for (String word: words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
        }

        return set.size();
    }

    public static void main(String[] args){

        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(new Leetcode804().uniqueMorseRepresentations(words));
    }


}
