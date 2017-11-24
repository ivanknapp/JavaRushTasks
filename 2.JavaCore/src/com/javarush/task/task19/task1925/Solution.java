package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        ArrayList<String> list = new ArrayList<>();

        while (reader.ready()){
            String[] strings = reader.readLine().split(" ");
            for (String s : strings) {
                list.add(s);
            }
        }
        reader.close();
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            if (s.length()>6) {
                sb.append(s+",");
            }
        }
        writer.write(sb.toString().substring(0,sb.length()-1));
        writer.close();
    }
}
