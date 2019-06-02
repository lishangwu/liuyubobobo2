/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/2/2 02:33
 */

package com.HashCode;

/**
 * Created by robin on 2019/2/2.
 */
public class Student {

    private int grade;
    private int cls;

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
        hash = hash * B + firstName.toLowerCase().hashCode();
        hash = hash * B + lastName.toLowerCase().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Student another = (Student) obj;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }
}
