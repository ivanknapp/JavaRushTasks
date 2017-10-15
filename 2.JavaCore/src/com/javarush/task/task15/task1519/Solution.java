package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data ;
        ArrayList <String> list = new ArrayList<String>();

        while (true){
            data = reader.readLine();
            if (data.equals("exit")) break;
            list.add(data);
        }

        for (String i : list) {
        try {
            if (i.contains(".")) print(Double.parseDouble(i));
            else
                throw new Exception();
        } catch (Exception e){
            try {
                if (Integer.parseInt(i) > 0 & Integer.parseInt(i) < 128 )
                    print(Short.parseShort(i));
                else
                    throw new Exception();
            } catch (Exception e1){
                try {
                    print(Integer.parseInt(i));
                } catch (Exception e2){
                    print(i);
                }
            }
        }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
