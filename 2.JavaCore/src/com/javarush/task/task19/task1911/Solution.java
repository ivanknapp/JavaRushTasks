package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        //zapomnili peremennyy
        PrintStream consolePrint = System.out;
        //sozdaem massiv dlya zapisi dannix
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //sozdaem adapter
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        testString.printSomething();

        String result = byteArrayOutputStream.toString();

        System.setOut(consolePrint);

        String newResult = result.toUpperCase();

        System.out.println(newResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
