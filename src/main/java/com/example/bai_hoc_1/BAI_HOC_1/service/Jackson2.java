package com.example.bai_hoc_1.BAI_HOC_1.service;

import com.example.bai_hoc_1.BAI_HOC_1.entity.Student2;
import com.example.bai_hoc_1.BAI_HOC_1.entity.Contact;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Jackson2 {
    public static void main(String[] args) throws IOException {
        demo8();
    }

    private static void demo8() {
//        System.out.println(Stream.of(1, 9, 3, 7, 6, 2).filter(n -> n % 3 == 0).reduce(0, (p, c) -> p + c));
        System.out.println(Stream.of(1, 9, 3, 7, 6, 2).filter(n -> n % 3 == 0).reduce(10, (p, c) -> p > c ? c : p));
    }

    private static void demo7() throws IOException {
        Contact contact = new Contact("hoangbv@gamail.com", "984348938438", null);
        List<String> subject = Arrays.asList("JH4343","FG2333","IK4343");
        Student2 student = new Student2("Hoàng Thanh Tâm", true, 3.6, contact, subject);
        ObjectMapper mapper = new ObjectMapper();
        // CHUYỂN THÀNH STRING
        String json = mapper.writeValueAsString(student);
        // VIẾT KIỂU ĐẦU RA CHO CHUỖI
        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
        // VIẾT VÀO FILE
        mapper.writeValue(new File("E:/LAP_TRINH_JAVA_TUAN_PH20022/FILE_JSON/student3.json"), student);
    }

    private static void demo6() throws IOException {
        Map<String, Object> contact = new HashMap<String, Object>();
        contact.put("email", "tamnq@gmail.com");
        contact.put("phone", "0785458747");
        List<String> subject = Arrays.asList("WEB205", "HG3243", "JH2233");
        Map<String, Object> student = new HashMap<String, Object>();
        student.put("name", "Nguyễn Quốc Tuấn");
        student.put("marks", 9.0);
        student.put("gender", false);
        student.put("contact", contact);
        student.put("subject", subject);
        ObjectMapper mapper = new ObjectMapper();
        // CHUYỂN THÀNH STRING
        String json = mapper.writeValueAsString(student);
        System.out.println(json);
        // VIẾT KIỂU ĐẦU RA CHO CHUỖI
        mapper.writeValue(System.out, student);
        // VIẾT VÀO FILE
        mapper.writeValue(new File("E:/LAP_TRINH_JAVA_TUAN_PH20022/FILE_JSON/student2.json"), student);
    }

    private static void demo5() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Nguyễn Quốc Tuấn");
        student.put("marks", 7.5);
        student.put("gender", true);
        ObjectNode contact = student.putObject("contact");
        contact.put("email", "tuannq@gmail.com");
        contact.put("phone", "05454454");
        ArrayNode subject = student.putArray("subject");
        subject.add("WEB205");
        subject.add("COM108");
        subject.add("SD1073");
        // CHUYỂN JACKSON THÀNH STRING
        String json = mapper.writeValueAsString(student);
        // VIẾT KIỂU ĐẦU RA CHO CHUỖI
        mapper.writeValue(System.out, student);
        // VIẾT VÀO FILE
        mapper.writeValue(new File("E:/LAP_TRINH_JAVA_TUAN_PH20022/FILE_JSON/student.json"), student);
    }

    private static void demo4() throws IOException {
        String path = "E:\\LAP_TRINH_JAVA_TUAN_PH20022\\LAP_TRINH_JAVA_6\\BAI_HOC_ONLINE\\BAI_HOC_1\\src\\main\\resources\\students.json";
        TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {
        };
        ObjectMapper mapper = new ObjectMapper();
        List<Student2> students = mapper.readValue(new File(path), type);
        students.forEach(student -> {
            System.out.println(">> Name: " + student.getName());
            System.out.println(">> Mark: " + student.getMarks());
            System.out.println(">> Gender: " + student.getGender());
            System.out.println("----------------------------------------------------------------");
        });
    }

    private static void demo3() throws IOException {
        String path = "E:\\LAP_TRINH_JAVA_TUAN_PH20022\\LAP_TRINH_JAVA_6\\BAI_HOC_ONLINE\\BAI_HOC_1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Student2 student = mapper.readValue(new File(path), Student2.class);
        System.out.println(">> Name: " + student.getName());
        System.out.println(">> Mark: " + student.getMarks());
        System.out.println(">> Gender: " + student.getGender());
        Contact contact = student.getContact();
        System.out.println(">> Email: " + contact.getEmail());
        System.out.println(">> Phone: " + contact.getPhone());
        List<String> subjects = student.getSubject();
        subjects.forEach(subject -> {
            System.out.println(">> Subject: " + subject);
        });
    }

//    private static void demo2() throws IOException {
//        String path = "E:\\LAP_TRINH_JAVA_TUAN_PH20022\\LAP_TRINH_JAVA_6\\BAI_HOC_ONLINE\\BAI_HOC_1\\src\\main\\resources\\students.json";
//        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
//        students.forEach(student -> {
//            System.out.println(">> Name: " + student.get("name"));
//            System.out.println(">> Mark: " + student.get("marks"));
//            System.out.println(">> Gender: " + student.get("gender"));
//            System.out.println("----------------------------------------------------------------");
//        });
//    }
//
//    private static void demo1() throws IOException {
//        String path = "E:\\LAP_TRINH_JAVA_TUAN_PH20022\\LAP_TRINH_JAVA_6\\BAI_HOC_ONLINE\\BAI_HOC_1\\src\\main\\resources\\student.json";
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> student = mapper.readValue(new File(path), Map.class);
//        System.out.println(">> Name: " + student.get("name"));
//        System.out.println(">> Mark: " + student.get("marks"));
//        System.out.println(">> Gender: " + student.get("gender"));
//        Map<String, Object> contact = (Map<String, Object>) student.get("contact");
//        System.out.println(">> Email: " + contact.get("email"));
//        System.out.println(">> Phone: " + contact.get("phone"));
//        List<String> subjects = (List<String>) student.get("subject");
//        subjects.forEach(subject -> {
//            System.out.println(">> Subject: " + subject);
//        });
//    }
}
