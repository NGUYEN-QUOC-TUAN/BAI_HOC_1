package com.example.bai_hoc_1.BAI_HOC_1.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        Stream<Integer> stream1 = Stream.of(1, 9, 6, 5, 2, 4, 10, 12, 16, 22, 21, 45);
        stream1.forEach(n -> {
            System.out.println(n);
        });
        List<Integer> list = Arrays.asList(1, 9, 6, 5, 2, 4, 10, 12, 16, 22, 21, 45);
//        Stream<Integer> stream2 = list.stream();
        list.forEach(n -> System.out.println(n));
    }
}
