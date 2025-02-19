package com.basicproblems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {

    public static void main(String[] args) {
        String path="output.csv";
        try (BufferedWriter writer= new BufferedWriter(new FileWriter(path))){

            writer.write("ID,Name,Department,Salary\n");
            writer.write("101,Shivraj,Finance,62000\n");
            writer.write("102,Sujal ,Sales,58000\n");
            writer.write("103,Survesh,DEvloper,75000\n");
            writer.write("104,Riya ,Finance,62000\n");
            writer.write("105,Bhavya,Tech,780000\n");
            writer.write("106,Tarun,Tech,750000\n");
            System.out.println("CSV file written successfully!");


        }catch (IOException e)
        {
            System.out.println("Error !!! " +e.getMessage());
        }



    }


}
