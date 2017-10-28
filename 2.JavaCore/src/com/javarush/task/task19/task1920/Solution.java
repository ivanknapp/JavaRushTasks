package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> nameSalary = new TreeMap<>();

        while (reader.ready()){
            String[] data = reader.readLine().split(" ");
            nameSalary.put(data[0], ((nameSalary.get(data[0])==null? 0.0 : nameSalary.get(data[0]))+ Double.parseDouble(data[1])));
        }
        reader.close();

        HashSet<String> aRichestSlaves = new HashSet<>();
        double max = 0;
        for (Map.Entry<String, Double> entry: nameSalary.entrySet()){
            if (entry.getValue() >= max) {
                max = entry.getValue();
                aRichestSlaves.add(entry.getKey());
            }
        }
        aRichestSlaves.forEach((k) -> System.out.println(k));
    }
}
