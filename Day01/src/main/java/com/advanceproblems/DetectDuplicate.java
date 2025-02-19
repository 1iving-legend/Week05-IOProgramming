package com.advanceproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicate {
    public static void main(String[] args) {
        String csvFile = "output.csv";
        String delimiter = ",";

        Map<String, List<String>> recordMap = new HashMap<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine(); // Read the header
            System.out.println("Header: " + header);
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                String id = values[0];

                if (recordMap.containsKey(id)) {
                    duplicateRecords.add(line);
                } else {
                    recordMap.put(id, Arrays.asList(values));
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
