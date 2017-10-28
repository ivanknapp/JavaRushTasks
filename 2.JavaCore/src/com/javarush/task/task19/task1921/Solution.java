package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()){
            String[] data = reader.readLine().split(" ");
            String name = "";
            for (int i = 0; i <data.length-3 ; i++) {
                name += data[i] + " ";
            }
            Date date = new SimpleDateFormat("dd MM yyyy").parse(data[data.length-3]+ " " + data[data.length-2] + " " + data[data.length-1]);
            PEOPLE.add(new Person(name.trim(), date));
        }
        reader.close();

        //PEOPLE.forEach((k) -> System.out.println(k.getName() + " " + k.getBirthday()));


    }
}
