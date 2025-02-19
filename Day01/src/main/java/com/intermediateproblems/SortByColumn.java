package com.intermediateproblems;

import java.io.*;
import java.util.ArrayList;

public class SortByColumn {
    public static void main(String[] args) {
        String path="output.csv";
        String t="";
        ArrayList<String[]> temp= new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader(path)))
        {
           String line= br.readLine();
           t=line;
           while((line=br.readLine())!=null)
           {
               String[] val=line.split(",");
               temp.add(val);
           }
           temp.sort((a,b)->Double.compare(Double.parseDouble(b[3]),Double.parseDouble(a[3])));

        }
        catch(IOException m)
        {
            System.out.println("Error !!! "+ m.getMessage());
        }

        try(BufferedWriter writer= new BufferedWriter(new FileWriter("sortedresult.csv"))){
           writer.write(t+"\n");
           for(int i=0;i<temp.size();i++)
           {
               String data=temp.get(i)[0]+","+temp.get(i)[1]+","+temp.get(i)[2]+","+temp.get(i)[3]+"\n";
               writer.write(data);
               if(i<5)
               {
                   System.out.println(data);
               }
           }
        }
        catch(IOException e)
        {
            System.out.println("Error !!! "+ e.getMessage());
        }
    }
}
