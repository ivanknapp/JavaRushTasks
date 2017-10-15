package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();

            FileInputStream inputStream = new FileInputStream(fileName);
            ArrayList<Integer> list = new ArrayList<Integer>();

            while (inputStream.available()>0){
                    int data = inputStream.read();
                    list.add(data);
            }
            ArrayList<Integer> listCopy = new ArrayList<>(list);

            Integer[] array = new Integer[listCopy.size()];
            array = listCopy.toArray(array);
            Arrays.sort(array);


            for (int i = 0; i < array.length-1; i++) {
                if (!array[i].equals(array[i+1]))
                    System.out.print(array[i] + " ");
                if (i==array.length-2)
                    System.out.print(array[i+1]);
            }

            reader.close();
            inputStream.close();

        } catch (Exception e){
            System.out.println("Ошибочка");
        }
    }
}
