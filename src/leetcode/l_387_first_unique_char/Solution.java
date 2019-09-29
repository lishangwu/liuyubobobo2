/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/9/27 01:58
 */

package leetcode.l_387_first_unique_char;

public class Solution {

    private int firstUniqChar(String s){

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(freq[c - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        System.out.println(new Solution().firstUniqChar("helloworldh"));

    }

}

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 案例:

 s = "leetcode"
 返回 0.

 s = "loveleetcode",
 返回 2.
 注意事项：您可以假定该字符串只包含小写字母。
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */