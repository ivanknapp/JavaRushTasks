package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
/*        Integer[] integers = new Integer[]{13, 8, 15, 5, 17};

        for (Integer i : integers) {
            System.out.print(i + " ");
        }
        System.out.println();

        Integer[] integers1 = sort(integers);


        System.out.println();
        for (Integer i : integers1) {
            System.out.print(i + " ");
        }*/
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        //Integer[] array = arrays.clone();
        Arrays.sort(array);

        int meridian;
        if (array.length % 2 == 0) {
            meridian = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
/*            System.out.println(array[array.length / 2 - 1]);
            System.out.println(array[array.length / 2]);*/
            //System.out.println("meridian = " + meridian);
        }
        else {
            meridian = array[array.length / 2];
            //System.out.println("meridian = " + meridian);
        }

        Comparator <Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1-meridian) - Math.abs(o2 - meridian);
            }
        };

        Arrays.sort(array, comparator);

/*
        Arrays.sort(sortarray);

        int[] high = new int[sortarray.length/2];
        int[] low = new int[sortarray.length/2];

        for (int i = 0; i < sortarray.length / 2; i++) {
            high[high.length - i - 1] = sortarray[sortarray.length - i - 1];
            low[i] = sortarray[i];
        }
        sortarray[0] = array[0];
        for (int i = 0; i < sortarray.length / 2; i++) {
            sortarray[i + 1] = high[i];
            sortarray[i + 1 + sortarray.length / 2] = low[low.length - i - 1];
        }
*/

        return array;
    }
}
