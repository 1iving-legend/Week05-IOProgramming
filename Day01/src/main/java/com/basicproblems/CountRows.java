package com.basicproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {

    public static void main(String[] args) {

        String path="output.csv";
        try(BufferedReader reader= new BufferedReader(new FileReader(path)))
        {
             String line= reader.readLine();
             String []arr= line.split(",");
            System.out.println("No. of columns = "+arr.length);
            int count=0;
            while((line= reader.readLine())!=null)
            {
                count++;
            }
            System.out.println("No. of rows = "+count);
        }
        catch (IOException m)
        {
            System.out.println("Error !!! "+ m.getMessage());
            m.printStackTrace();
        }
    }
}
