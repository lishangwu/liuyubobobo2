/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/2/2 02:32
 */

package com.HashCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by robin on 2019/2/2.
 */
public class Main {

    public static void main(String[] args){
        
        int a = 12;
        System.out.println(((Integer) a).hashCode());

        System.out.println(new Student(3, 2, "bobo", "Liu").hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(new Student(3, 2, "bobo", "Liu"));
        HashMap<Student, Integer> map = new HashMap<>();
        map.put(new Student(3, 2, "bobo", "Liu"), 100);

    }

}
