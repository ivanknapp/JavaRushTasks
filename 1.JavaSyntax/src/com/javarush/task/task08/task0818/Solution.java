package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Иванов", 500);
        map.put("Петров", 1500);
        map.put("Сидоров", 400);
        map.put("Методов", 300);
        map.put("Маинов", 600);
        map.put("Кук", 200);
        map.put("Товар", 900);
        map.put("Солютов", 100);
        map.put("Гренка", 800);
        map.put("Клава", 1000);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<HashMap.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            HashMap.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue()<500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {
    }
}