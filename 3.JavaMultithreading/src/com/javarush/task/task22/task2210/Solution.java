package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
/*        String[] test = getTokens("level22.lesson13.task01", ".");

        for (String s : test) {
            System.out.print(s + ", ");
        }*/

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] strings = new String[tokenizer.countTokens()];
        int i= 0;
        while (tokenizer.hasMoreElements()){
            strings[i] = tokenizer.nextToken();
            i++;
        }
        return strings;
    }
}
