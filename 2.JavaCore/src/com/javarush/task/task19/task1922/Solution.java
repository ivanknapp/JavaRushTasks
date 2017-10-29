package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл"); // файл
        words.add("вид"); // вид
        words.add("В"); //В
    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String[]> strings = new ArrayList<>();
        String[] data = null;
        while (reader.ready()){
            data = reader.readLine().split(" ");
            strings.add(data);
        }
        reader.close();

/*        for (String s :words) {
            System.out.print(s + " - ");
        }
        System.out.println();

        for (String[] s :strings) {
            System.out.print(aWordConcat(s) + " - ");
        }
        System.out.println();*/

        int match = 0;
        for (int i = 0; i < strings.size(); i++) {
            for (int j = 0; j < strings.get(i).length; j++) {
                for (int k = 0; k < words.size(); k++) {
                    String temp = strings.get(i)[j];
                    String word = words.get(k);
                    if (temp.equals(word)) {
                        match++;
                    }
                }
            }
            if (match==2)
                System.out.println(aWordConcat(strings.get(i)));
            match = 0;
        }

    }

    public static String aWordConcat(String[] string){
        String result = "";
        for (int i = 0; i < string.length; i++) {
            result += string[i] + " ";
        }
        return result.trim();
    }
}
