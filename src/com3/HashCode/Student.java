/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/6/11 16:53
 */

package com3.HashCode;

public class Student {

    int grade;
    int cls;
    String firstName;
    String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.hashCode();
        hash = hash * B + lastName.hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object o) {

        if(this == o)
            return true;
        if(o == null)
            return false;
        if(getClass() != o.getClass())
            return false;
        Student another = (Student)o;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.equals(another.firstName) &&
                this.lastName.equals(another.lastName);
    }

    public static void main(String[] args){

        System.out.println(new Student(1, 2, "sb", "sb").hashCode());
        System.out.println(new Student(1, 22, "sb", "sb").hashCode());

    }
}
