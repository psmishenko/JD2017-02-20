package by.it.korzun.jd02_10;

import java.util.Arrays;

public class Student {
    private String name;
    private int grade;
    private int marks[];

    public Student(String name, int grade, int[] marks) {
        this.name = name;
        this.grade = grade;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
