package com.practiceproblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

class Student {
    @JsonProperty
    private String name;

    @JsonProperty
    private int age;

    @JsonProperty
    private String[] subject;

    public Student(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject.split(" ");
    }

    // Optional: To help debugging
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", subject=" + Arrays.toString(subject) + "}";
    }
}

public class CreateJsonObjectStudents {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Student stud1 = new Student("Alice", 25, "Hindi Math English Science");
            // Convert Java Object to JSON String
            String jsonString = objectMapper.writeValueAsString(stud1);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
