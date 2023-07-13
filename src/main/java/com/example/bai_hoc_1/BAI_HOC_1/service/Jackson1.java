package com.example.bai_hoc_1.BAI_HOC_1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson1 {
    public static void main(String[] args) throws IOException {
        demo2();
    }

    private static void demo2() throws IOException {
        String path = "E:\\LAP_TRINH_JAVA_TUAN_PH20022\\LAP_TRINH_JAVA_6\\BAI_HOC_ONLINE\\BAI_HOC_1\\src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode students = mapper.readTree(new File(path));
        students.iterator().forEachRemaining(student -> {
            System.out.println(">> Name: " + student.get("name").asText());
        });
    }

//    private static void demo1() throws IOException {
//        String path = "E:\\LAP_TRINH_JAVA_TUAN_PH20022\\LAP_TRINH_JAVA_6\\BAI_HOC_ONLINE\\BAI_HOC_1\\src\\main\\resources\\student.json";
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode student = mapper.readTree(new File(path));
//        System.out.println(">> Name: " + student.get("name").asText());
//        System.out.println(">> Mark: " + student.get("marks").asDouble());
//        System.out.println(">> Gender: " + student.get("gener").asBoolean());
//        System.out.println(">> Email: " + student.get("contact").get("email").asText());
//        System.out.println(">> Phone: " + student.findValue("phone").asText());
//        student.get("subject").iterator().forEachRemaining(subject -> {
//            System.out.println(">> Subject: " + subject.asText());
//        });
//    }
}
