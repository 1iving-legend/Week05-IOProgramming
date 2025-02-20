package com.practiceproblems;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode mergeJson(JsonNode json1, JsonNode json2) {
        ObjectNode mergedNode = objectMapper.createObjectNode();
        mergedNode.setAll((ObjectNode) json1);
        mergedNode.setAll((ObjectNode) json2);
        return mergedNode;
    }

    public static void main(String[] args) {
        String json1 = "{\"name\": \"Alice\", \"age\": 25}";
        String json2 = "{\"city\": \"New York\", \"country\": \"USA\"}";
        ObjectMapper objectmaper = new ObjectMapper();
        JsonNode rootnode1;
        JsonNode rootnode2;
        try {
            rootnode1 = objectmaper.readTree(json1);
            rootnode2 = objectmaper.readTree(json2);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String res= String.valueOf(mergeJson(rootnode1, rootnode2));
        System.out.println(res);
    }
}
