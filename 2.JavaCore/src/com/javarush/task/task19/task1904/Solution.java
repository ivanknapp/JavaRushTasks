package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String s1 = fileScanner.next();
            String[] s = s1.split(" ");
            return new Person(s[1], s[2], s[0],  new Date(s[3]+"/"+s[4]+"/"+s[5]));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
