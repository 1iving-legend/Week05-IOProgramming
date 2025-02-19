package com.intermediateproblems;

import java.io.*;

import static java.lang.Double.parseDouble;

public class UpdateSalory {

    public static void main(String[] args) {
        String path="output.csv";
        String newfile= "updatedFile.csv";

        try(BufferedReader br= new BufferedReader(new FileReader(path));
            BufferedWriter writer= new BufferedWriter(new FileWriter(newfile))
        )
        {
            String line;
            line= br.readLine();
            writer.write(line+"\n");
            while((line= br.readLine())!=null)
            {
                String []col=line.split(",");
                col[3]= String.valueOf(parseDouble(col[3])+(0.1* parseDouble(col[3])));
                 String res= col[0]+","+col[1]+","+col[2]+","+col[3]+"\n";
                    String val=res;
                    writer.write(val);

            }
        }
        catch (IOException m)
        {
            System.out.println("Error !!! "+ m.getMessage());
        }
    }
}
