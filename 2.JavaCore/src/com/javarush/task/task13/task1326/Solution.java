package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            InputStream inputStream = new FileInputStream(reader.readLine());
            String tmp = "";
            ArrayList<Integer> list = new ArrayList<>();
            //считываем байты из файла
            while (inputStream.available()>0){
                int data = inputStream.read();
                if (data == 10) {
                    list.add(Integer.parseInt(tmp));
                    tmp="";
                    continue;
                } else if (data == 13)
                    continue;
                else
                    tmp+= (char)data;
                if (inputStream.available()==0)
                    list.add(Integer.parseInt(tmp));
            }
            //сортируем лист
            Integer[] array = list.toArray(new Integer[list.size()]);
            Arrays.sort(array);

            for (Integer i : array) {
                if (i%2==0) System.out.println(i);
            }
            reader.close();
            inputStream.close();

        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
