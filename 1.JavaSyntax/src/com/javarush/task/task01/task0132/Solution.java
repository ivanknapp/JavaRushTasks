package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args)
    {
        System.out.println(sumDigitsInNumber(546));
    }
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public static int sumDigitsInNumber(int number)
    {

        //напишите тут ваш код
        int a = number%10;
        int b = number/10;


        int c = b%10;
        int d = number/100;

        return (a+c+d);
    }
}