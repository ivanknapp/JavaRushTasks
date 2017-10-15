package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consolePrint = System.out;

        ByteArrayOutputStream dataByte = new ByteArrayOutputStream();

        PrintStream printAdapter = new PrintStream(dataByte);

        System.setOut(printAdapter);

        testString.printSomething();

        String result = dataByte.toString().replaceAll("te", "??");

        System.setOut(consolePrint);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
