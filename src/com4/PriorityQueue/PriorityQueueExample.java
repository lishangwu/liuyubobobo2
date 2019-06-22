/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/13 13:01
 */

package com4.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueExample {

    public static void test1(){
        Queue<Integer> q = new PriorityQueue<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            q.add(random.nextInt(100));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(q.remove());
        }
    }

    public static void test2(){
        Queue<Integer> q = new PriorityQueue<>(7, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            q.add(random.nextInt(100));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(q.remove());
        }
    }

    public static void test3(){
        Queue<Customer> q = new PriorityQueue<>(7, new Comparator<Customer>() {
            @Override
            public int compare(Customer a, Customer b) {
                return a.getId() - b.getId();
            }
        });

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            q.add(new Customer(random.nextInt(100), "sb"));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(q.remove());
        }
    }

//    public static Comparator



    public static void main(String[] args){

        asd:
        asd2:
        http://www.importnew.com/6932.html

        test3();
                
    }

}


class Customer{
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getId() + "\t" + getName();
    }
}