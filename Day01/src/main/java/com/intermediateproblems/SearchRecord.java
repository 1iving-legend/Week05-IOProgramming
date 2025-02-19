package com.intermediateproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {

    public static void main(String[] args) {
        String path="output.csv";
        String target="Shivraj";

        try(BufferedReader br= new BufferedReader(new FileReader(path)))
        {
            String line;
            line= br.readLine();
            while((line= br.readLine())!=null)
            {
                String []col=line.split(",");
                if(col[1].toLowerCase().equals(target.toLowerCase())){
                    System.out.print("ID: "+col[0]+ "\nName :"+col[1]+ "\nsalory : "+col[3]+"\nDepartment : "+col[2]);
                }
            }
        }
        catch (IOException m)
        {
            System.out.println("Error !!! "+ m.getMessage());
        }
    }
}
