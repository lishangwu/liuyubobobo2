/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/5 00:05
 */

package leetcode;

public class Sum {

    public static int sum(int[] arr){
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l){
        if(l == arr.length)
            return 0;
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args){

        int[] nums = {1,2,3,4,5};
        System.out.println(sum(nums));

    }

}
