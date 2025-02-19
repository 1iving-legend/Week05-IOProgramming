package com.advanceproblems;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.*;
import java.util.*;

public class JsonToCSV {
    private static final String JSON_FILE = "students.json";
    private static final String CSV_FILE = "students1.csv";
    private static final String CONVERTED_JSON_FILE = "converted_students.json";

    public static void main(String[] args) {
        try {
            //jsonToCsv(JSON_FILE, CSV_FILE);
            csvToJson(CSV_FILE, CONVERTED_JSON_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFile, String csvFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(jsonFile));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            // Writing CSV Header
            writer.write("ID,Name,Age,Grade");
            writer.newLine();

            for (JsonNode node : rootNode) {
                int id = node.get("id").asInt();
                String name = node.get("name").asText();
                int age = node.get("age").asInt();
                String grade = node.get("grade").asText();

                writer.write(id + "," + name + "," + age + "," + grade);
                writer.newLine();
            }
        }
        System.out.println("JSON converted to CSV successfully!");
    }

    // Convert CSV back to JSON
    public static void csvToJson(String csvFile, String jsonFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line = reader.readLine(); // Read header
            String[] headers = line.split(",");

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> student = new LinkedHashMap<>();

                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], values[i]);
                }
                students.add(student);
            }
        }

        objectMapper.writeValue(new File(jsonFile), students);
        System.out.println("CSV converted to JSON successfully!");
    }
}
