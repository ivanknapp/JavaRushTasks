package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {

            if (args[0].equals("-c")){
                Person person;
                if (args[2].equals("м"))
                    person = Person.createMale(args[1], format.parse(args[3]));
                else
                    person = Person.createFemale(args[1], format.parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
            if (args[0].equals("-u")){
                if (args[3].equals("м"))
                    allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], format.parse(args[4])));
                else
                    allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2],format.parse(args[4])));
            }
            if (args[0].equals("-d")){
                //allPeople.set(Integer.parseInt(parameters[1]), allPeople.get(Integer.parseInt(parameters[1])).setName("null"));
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
            }
            if (args[0].equals("-i")){
                format = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);

                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " +
                        (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                        format.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
