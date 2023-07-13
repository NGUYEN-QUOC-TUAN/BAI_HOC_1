package com.example.bai_hoc_1.BAI_HOC_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Student {
    private String name;
    private Boolean gender = false;
    private Double marks = 0.0;
}
