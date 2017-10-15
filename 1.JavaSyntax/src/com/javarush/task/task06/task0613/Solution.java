package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        //создай 10 котов
        Cat cat1 = new Cat();
        Cat cat21 = new Cat();
        Cat cat211 = new Cat();
        Cat cat1123 = new Cat();
        Cat cat311 = new Cat();
        Cat cat33111 = new Cat();
        Cat ca231t1 = new Cat();
        Cat cat3121 = new Cat();
        Cat cat31221 = new Cat();
        Cat cat312211 = new Cat();
        //выведи значение переменной catCount
        System.out.println(Cat.catCount);
    }

    public static class Cat {
        //создай статическую переменную catCount
        public static int catCount=0;

        //создай конструктор
        public Cat() {
            catCount++;
        }
    }
}
