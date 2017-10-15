package com.javarush.task.task08.task0817;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        map.put("Иванов", "Иван");
        map.put("Петров", "Иван");
        map.put("Сидоров", "Иван");
        map.put("Методов", "Иван");
        map.put("Тайландов", "Иван");
        map.put("Джававоч", "Иван");
        map.put("Фонарёв", "Иван");
        map.put("Фингалов", "Иван");
        map.put("Фарангов", "Иван");
        map.put("Траблов", "Трабл");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copyMap1 = new HashMap<>(map);
        HashMap<String, String> copyMap2 = new HashMap<>(map);

        for (HashMap.Entry<String, String> pair : copyMap1.entrySet()) {
            copyMap2.remove(pair.getKey());
            if (copyMap2.containsValue(pair.getValue()))
                removeItemFromMapByValue(map, pair.getValue());
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    }
}
