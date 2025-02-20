package com.practiceproblems;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterJson {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode filterByAge(JsonNode jsonArray) {
        ArrayNode filteredArray = objectMapper.createArrayNode();
        for (JsonNode node : jsonArray) {
            if (node.has("age") && node.get("age").asInt() > 25) {
                filteredArray.add(node);
            }
        }
        return filteredArray;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String data = "[{\"name\":\"Bhavya\",\"age\":29},{\"name\":\"riya\",\"age\":22},{\"name\":\"Shivraj\",\"age\":32},{\"name\":\"Sujal\",\"age\":22},{\"name\":\"survesh\",\"age\":22}]";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);

        JsonNode resultNode = filterByAge(rootNode);
        String res = mapper.writeValueAsString(resultNode);  // Convert JsonNode to String

        System.out.println(res);  // Print the filtered JSON
    }
}
