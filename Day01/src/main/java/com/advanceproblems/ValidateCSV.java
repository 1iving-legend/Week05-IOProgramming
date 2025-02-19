package com.advanceproblems;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ValidateCSV {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    private static final String PHONE_REGEX = "^\\d{10}$";

    private static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    private static boolean isValidPhone(String phone) {
        return phone.matches(PHONE_REGEX);
    }

    public static void validateCsv(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String header = br.readLine();
            if (header == null) return;
            bw.write(header + ",Error" + System.lineSeparator());

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length < 2) continue;

                String email = values[0].trim();
                String phone = values[1].trim();

                List<String> errors = new ArrayList<>();
                if (!isValidEmail(email)) errors.add("Invalid Email");
                if (!isValidPhone(phone)) errors.add("Invalid Phone Number");

                if (!errors.isEmpty()) {
                    System.out.println("Invalid row: " + line + " | Errors: " + String.join(", ", errors));
                    bw.write(line + "," + String.join(", ", errors) + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        validateCsv("input_data.csv", "invalid_data.csv");
    }
}
