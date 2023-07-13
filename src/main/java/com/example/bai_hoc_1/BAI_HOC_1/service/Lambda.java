package com.example.bai_hoc_1.BAI_HOC_1.service;

import com.example.bai_hoc_1.BAI_HOC_1.entity.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {
    static List<Student> listStudents = Arrays.asList(
            new Student("Quốc Tuấn", true, 7.4),
            new Student("Văn Lượng", false, 9.3),
            new Student("Hoàng Ngân", true, 6.8),
            new Student("Trung Kiên", false, 9.2),
            new Student("Đình Thùy", true, 2.5)
    );

    public static void main(String[] args) {
        demo4();
    }

    private static void demo4() {
        Demo4Inter o = x -> System.out.println(x);
        o.m1(2021);
    }

    private static void demo3() {
        Collections.sort(listStudents, (sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));
        listStudents.forEach(sv -> {
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println();
        });
    }

    private static void demo2() {
        listStudents.forEach(sv -> {
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println();
        });
    }

    public static void demo1() {
        List<Integer> list = Arrays.asList(1, 9, 6, 5, 2, 4, 10, 12, 16, 22, 21, 45);
        list.forEach(n -> System.out.println(n));
    }
}

@FunctionalInterface
interface Demo4Inter {
    void m1(int x);

    default void m2() {
    }

    public static void m3() {
    }
}