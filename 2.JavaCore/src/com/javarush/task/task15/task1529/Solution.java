package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {
    }
    
    static {
        //add your code here - добавьте код тут
        try {
            Solution.reset();
        }catch (Exception e){

        }
    }

    public static Flyable result;

    public static void reset()  throws IOException{
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        if (text.equals("helicopter"))
            result = new Helicopter();
        if (text.equals("plane")){
            String passengers = reader.readLine();
            result = new Plane(Integer.parseInt(passengers));
        }
        reader.close();
    }
}
