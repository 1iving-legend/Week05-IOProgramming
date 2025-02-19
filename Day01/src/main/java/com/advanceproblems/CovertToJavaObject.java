package com.advanceproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// Student class to hold CSV data
class Student {
    int id;
    String name;
    int age;
    int marks;
    String grade;

    public Student(int id, String name, int age, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                ", Grade='" + grade + '\'' +
                '}';
    }
}

public class CovertToJavaObject {
    public static void main(String[] args) {
        String file1 = "merged.csv";

        List<Student> studentList = readCSV(file1);

        // Print students
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public static List<Student> readCSV(String file1) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                students.add(new Student(Integer.parseInt(values[0]),values[1] ,Integer.parseInt(values[2]),Integer.parseInt(values[3]), values[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
