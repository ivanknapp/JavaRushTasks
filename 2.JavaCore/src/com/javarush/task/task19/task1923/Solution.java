package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> words = new ArrayList<>();

        while (reader.ready()){
            String[] data = reader.readLine().split(" ");
            words.addAll(Arrays.asList(data));
        }
        reader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));

        for (String k : words) {
            if (k.matches(".*\\d+.*")) {
                System.out.print(k + " ");
                bufferedWriter.write(k + " ");
            }

        }
        bufferedWriter.close();
    }
}
