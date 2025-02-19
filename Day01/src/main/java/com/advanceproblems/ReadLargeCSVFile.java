package com.advanceproblems;

import java.io.*;

public class ReadLargeCSVFile {
    public static void main(String[] args) {
        String filePath = "Data8277.csv";
        int batchSize = 100;
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
                if (count % batchSize == 0) {
                    System.out.println("Records processed: " + count);
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
