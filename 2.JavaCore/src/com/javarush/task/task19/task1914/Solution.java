package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        testString.printSomething();

        String s = byteArrayOutputStream.toString();
        String[] result = s.split(" ");

        System.setOut(consoleStream);


        int number1 = Integer.parseInt(result[0]);
        int number2 = Integer.parseInt(result[2]);
        int resultOperation = result[1].equals("+") ? number1 + number2 :
                result[1].equals("-") ? number1 - number2 :
                        number1*number2;
        System.out.printf("%d %s %d = %d", number1, result[1], number2, resultOperation);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

