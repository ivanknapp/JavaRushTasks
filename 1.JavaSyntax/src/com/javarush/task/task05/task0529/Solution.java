package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = "0";
        int sum = 0;

        while (!num.equals("сумма")){
            sum = sum + Integer.parseInt(num);
            num = reader.readLine();
        }
        System.out.println(sum);
    }
}
