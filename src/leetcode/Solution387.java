/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/11 14:31
 */

package leetcode;

public class Solution387 {

    public int firstUniqChar(String s) {

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i) - 'a');
            freq[s.charAt(i) - 'a'] ++;
        }
        System.out.println();
        for (int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
    
    public static void main(String[] args){

        System.out.println(new Solution387().firstUniqChar("leetcode"));

    }

}
