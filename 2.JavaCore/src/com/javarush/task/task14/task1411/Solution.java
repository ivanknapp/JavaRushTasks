package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        ArrayList<String> keys = new ArrayList<>();
        keys.add("user");
        keys.add("coder");
        keys.add("loser");
        keys.add("proger");

        ArrayList<String> list = new ArrayList<>();

        while (true)//тут цикл по чтению ключей, пункт 1
        {
            key = reader.readLine();
            if (keys.contains(key))
                list.add(key);
            else
                break;
        }
            //создаем объект, пункт 2
        for (String s : list) {
            if (s.equals("user")) {
                person = new Person.User();
            } else if (s.equals("coder")) {
                person = new Person.Coder();
            } else if (s.equals("loser")) {
                person = new Person.Loser();
            } else if (s.equals("proger")) {
                person = new Person.Proger();
            }
            doWork(person); //вызываем doWork
        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User)
            ((Person.User) person).live();
        else if (person instanceof Person.Coder)
            ((Person.Coder) person).coding();
        else if (person instanceof Person.Loser)
            ((Person.Loser) person).doNothing();
        else if (person instanceof Person.Proger)
            ((Person.Proger) person).enjoy();
    }
}
