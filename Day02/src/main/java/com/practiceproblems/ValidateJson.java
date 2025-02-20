package com.practiceproblems;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static boolean isValidJson(String json) {
        try {
            objectMapper.readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String json1 = "{\"name\": \"Alice\", \"age\": 25}";
        String json2 = "{\"city\": \"New York\", \"country\": \"USA\"}";
        String json3= "vivek,23,bhopal,india";
        System.out.println(isValidJson(json1));
        System.out.println(isValidJson(json2));
        System.out.println(isValidJson(json3));
    }
}
