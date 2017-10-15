package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String tmp = "";
            ArrayList<String> parameters = new ArrayList<>();
            ArrayList<String> value = new ArrayList<>();
            String  url = reader.readLine();
            url = url.substring(url.indexOf("?")+1, url.length());
            String [] strings = url.split("&");
            Collections.addAll(parameters, strings);
            int i = 0;
            int j = 0;

            for (String s : parameters) {
                if (s.contains("=")) {
                    value.add(s.substring(s.indexOf("=") + 1, s.length()));
                    parameters.set(i, s.substring(0, s.indexOf("=")));
                } else value.add("null");
                i++;
            }
            for (String s :parameters) {
                System.out.print(s + " ");
            }
            System.out.println("");
            //System.out.println(value);

            for (String s : parameters) {
                if (s.equals("obj"))
                    try {
                        alert(Double.parseDouble(value.get(0)));
                    } catch (NumberFormatException e1) {
                        alert(value.get(0));
                    }
                j++;
            }
        reader.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
