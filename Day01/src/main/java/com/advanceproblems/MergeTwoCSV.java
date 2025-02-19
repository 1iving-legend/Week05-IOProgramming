package com.advanceproblems;

import java.io.*;
import java.util.ArrayList;

public class MergeTwoCSV {


    public static void merge(String path1, String path2)
    {
        ArrayList<ArrayList<String>> result= new ArrayList<>();
       try(
               BufferedReader br1= new BufferedReader(new FileReader(path1));
               BufferedReader br2= new BufferedReader(new FileReader(path2));
               BufferedWriter writer=new BufferedWriter(new FileWriter("merged.csv"));
           ) {
               String line1=br1.readLine();
               String line2=br2.readLine();
               writer.write(line1+",marks,grade\n");
               while((line1= br1.readLine())!=null && (line2= br2.readLine())!=null)
               {
                   String [] temp1= line1.split(",");
                   String[] arr=line2.split(",");
                   if(temp1[0].equals(arr[0])) {
                       String t = line1 + "," + arr[1] + "," + arr[2];
                       writer.write(t + "\n");
                   }
               }
           System.out.println("code executed sucessfully");


       }
       catch(IOException m){
           System.out.println("Error !!! "+m.getMessage());
       }
    }

    public static void main(String[] args) {
        merge("students1.csv","students2.csv");
    }
}
