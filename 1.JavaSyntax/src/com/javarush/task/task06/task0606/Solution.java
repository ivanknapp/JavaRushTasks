package com.javarush.task.task06.task0606;

import sun.awt.geom.Crossings;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int length = Integer.toString(n).length();

        for (int i = 0; i < length; i++) {
            int s=n%10%2==0?even++:odd++;
            n=n/10;
        }

        System.out.print("Even: "+even+" Odd: " + odd);

    }

}
