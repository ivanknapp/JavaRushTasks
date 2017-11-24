package com.javarush.task.task22.task2212;

import java.util.ArrayList;
import java.util.Arrays;

/*
Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с ‘+‘, то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков ‘—‘, которые не могут идти подряд
4) может содержать 1 пару скобок ‘(‘ и ‘)‘ , причем если она есть, то она расположена левее знаков ‘-‘
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false


Требования:
1. Метод checkTelNumber должен возвращать значение типа boolean.
2. Метод checkTelNumber должен быть публичным.
3. Метод checkTelNumber должен принимать один параметр типа String.
4. Метод checkTelNumber должен корректно проверять валидность номера телефона переданного ему в качестве параметра.
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        if (telNumber.isEmpty()) return false;

        char[] charArray = telNumber.toCharArray();
        int match = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 45)
                match++;
        }
        if (match>2) return false;

        return telNumber.matches("(\\+[0-9]{2})?(\\([0-9]{3}\\)|[0-9]{3})\\d\\-?\\d\\-?\\d\\-?\\d\\-?\\d\\-?\\d\\-?\\d");
    }

    public static void main(String[] args) {

/*        System.out.println("+380501234567 - " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567 - " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 - " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 - " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 - " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)12345-6-7 - " + checkTelNumber("+38(050)123-456-7"));
        System.out.println("050ххх4567 - " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 - " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - " + checkTelNumber("(0)501234567"));*/

    }
}
