package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man Seredja = new Man("Середжа",24, "Тихомирова");
        Man Edoo = new Man("Эдо",24, "Шокальскоого");

        Woman Nastya = new Woman("Настя",26,"Марьино");
        Woman Katya = new Woman("Katya", 24,"ВЫХИНО");

        System.out.println(Seredja.name +" " + Seredja.age +" " + Seredja.address);
        System.out.println(Edoo.name +" " + Edoo.age +" " + Edoo.address);
        System.out.println(Nastya.name +" " + Nastya.age +" " + Nastya.address);
        System.out.println(Katya.name +" " + Katya.age +" " + Katya.address);
    }

    //напишите тут ваш код
    public static class Man{
        String name;
        int age;
        String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman{
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
