package com.example.bai_hoc_1.BAI_HOC_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Student2 {
    private String name;
    private Boolean gender = false;
    private Double marks = 0.0;
    private Contact contact;
    private List<String> subject;
}
