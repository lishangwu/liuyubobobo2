/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/10 16:39
 */

package Test;

public class Test2 {


    public static void main(String[] args){
        
        int[] arr = new int[]{1,2,3};
        char[] arr1 = new char[]{'a','b', 'c'};

        System.out.println(arr);
        System.out.println(arr1);
//        [I@2b87514a
//                abc

        System.out.println();

        Object obj1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj1);  // 1.0

         Object o2;
        if(true){
            o2 = new Integer(1);
        }else {
            o2 = new Double(2.0);
        }

        System.out.println(o2); // 1

        System.out.println();

        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n); // true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); // false, -128 -- +127


    }


}
