package com.practiceproblems;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonObject {

    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        String output = "";

        try (BufferedReader br = new BufferedReader(new FileReader("Student-Data.json"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.append(line);
            }

            // Parse JSON object
            JSONObject obj = new JSONObject(input.toString());
            JSONArray studentsArray = obj.getJSONArray("students");

            // Iterate over the array and extract email addresses
            for (int i = 0; i < studentsArray.length(); i++) {
                JSONObject student = studentsArray.getJSONObject(i);
                String name = student.getString("name");
                String email = student.getString("email");
                System.out.println("Name: " + name + ", Email: " + email);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }
    }
}
