package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        char[] charArray = string.toCharArray();
        ArrayList<Character> chars = new ArrayList<>();
        for (char c : charArray) {
            chars.add(c);
        }

        ArrayList<Integer> indexOfSpace = new ArrayList<>();
        int i = 0;
        for (char c : charArray) {
            if (c == 32) {
                indexOfSpace.add(i);
            }
            i++;
        }

        if (indexOfSpace.size()<4)
            throw new TooShortStringException();
        else {

            //int firstIndex = indexOfSpace.get(0);
            //int secondIndex = indexOfSpace.get(4);
            String[] words = string.split(" ");
            return words[1] + " " + words[2] + " " + words[3] + " " + words[4] ;
        }
    }

    public static class TooShortStringException extends RuntimeException{

    }
}
