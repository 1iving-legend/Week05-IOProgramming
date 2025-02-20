package com.practiceproblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import  com.fasterxml.jackson.annotation.JsonProperty;


class Car{
    @JsonProperty
   private String brand;

    @JsonProperty
    private String name;

    @JsonProperty
    private double price;

    @JsonProperty
    private  String color;

    public Car(String brand, String name, double price, String color) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString()
    {
        return "Car{ Brand ="+brand+  ", Name=" + name + ", Price= " + price + " Color=" + color+"}" ;
    }
}

public class CarObjectToJson {

    public static void main(String[] args) {
        try{
            ObjectMapper om= new ObjectMapper();
            Car car1= new Car("Rolls Royce","Phantom",85000000.0,"white");
            String jsonValue= om.writeValueAsString(car1);
            System.out.println(jsonValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
