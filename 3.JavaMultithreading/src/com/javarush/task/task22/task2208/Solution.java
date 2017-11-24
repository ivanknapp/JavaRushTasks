package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
/*        Map<String, String> map = new HashMap<>();
        map.put("name",null);
        map.put("city","Kiev");
        map.put("country","Ukraine");
        map.put("age","16");
        map.put("family","Bukin");
        System.out.println(getQuery(map));*/
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue()!=null){
                if (sb.length()>0)
                    sb.append(" and ");
                sb.append(entry.getKey() + " = '" + entry.getValue() + "'");
            }
        }
        return sb.toString();
    }
}
