/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/22 13:10
 */

package Test;

import com5.Array.Array;

public class ArrayTest {

    public static void main(String[] args){


        Array<Integer> arr = new Array<>();

        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        arr.print();
        arr.addFirst(123);
        arr.print();
        arr.remove(4);
        arr.print();
        arr.removeFirst();
        arr.print();
        arr.removeLast();
        arr.print();

    }

}
