package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName;
            FileInputStream inputStream;

            while (true){
                fileName = reader.readLine();
                try {
                    inputStream = new FileInputStream(fileName);
                    inputStream.close();
                }catch (FileNotFoundException e){
                    System.out.println(fileName);
                    break;
                }
            }

            reader.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
