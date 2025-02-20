package com.practiceproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ListToJson {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode listToJsonArray(List<Person> people) {
        return objectMapper.valueToTree(people);
    }

    public static void main(String[] args) {
        List<Person> persons= new ArrayList<>();
        Person person1= new Person("Bhavya",21);
        Person person2= new Person("riya",22);
        Person person3= new Person("Shivraj",24);
        Person person4= new Person("Sujal",22);
        Person person5= new Person("survesh",22);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        String res= String.valueOf(listToJsonArray(persons));
        System.out.println(res);

    }


}
class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
