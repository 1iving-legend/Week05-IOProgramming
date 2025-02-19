package com.basicproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

    public static void main(String[] args) {

        String path= "output.csv";

        try(BufferedReader reader= new BufferedReader(new FileReader(path))){
            String line;
            while((line= reader.readLine())!=null)
            {
                String [] arr= line.split(",");
                System.out.println(arr[0]+"\t\t\t"+arr[1]+"\t\t\t"+arr[2]+"\t\t\t"+arr[3]);
            }

        } catch (IOException e) {

            System.out.println("Error !!! "+ e.getMessage());
            e.printStackTrace();
        }

    }
}
