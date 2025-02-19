package com.intermediateproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrint {
    public static void main(String[] args) {
        String path="student-dataset.csv";

        try(BufferedReader redaer= new BufferedReader(new FileReader(path)))
        {
            String line;
            line = redaer.readLine();
            int count=0;
            while((line= redaer.readLine())!=null)
            {
                String [] col= line.split(",");
                if(Double.parseDouble(col[3])>80)
                {
                    count++;
                    System.out.println(col[1]);
                }
            }
            System.out.println(count);
        }
        catch(IOException m)
        {
            System.out.println("Error !!! "+ m.getMessage());
            m.printStackTrace();
        }
    }
}
