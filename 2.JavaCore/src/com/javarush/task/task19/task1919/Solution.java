package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            TreeMap<String, Double> names = new TreeMap<>();

            while (bufferedReader.ready()){
                String[] data = bufferedReader.readLine().split(" ");
                names.put(data[0], (names.get(data[0])==null ? 0 : names.get(data[0])) + Double.parseDouble(data[1]));
            }

            bufferedReader.close();
            for (Map.Entry<String, Double> entry :names.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        }catch (FileNotFoundException e){
            System.out.println("файл не найден / file not found");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
