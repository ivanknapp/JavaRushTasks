package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе getLine должен быть использован StringBuilder
3. Метод getLine должен возвращать пустую строку(пустой StringBuilder) в случае если ему не были переданы параметры(слова).
4. Все слова переданные в метод getLine должны быть включены в результирующую строку, если это возможно.
5. Вывод на экран должен соответствовать условию задачи.
*/
public class Solution {
    public static void main(String[] args) {
        //...
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            reader = new BufferedReader(new FileReader(fileName));
            ArrayList<String> words = new ArrayList<>();

            while (reader.ready()){
                String[] data = reader.readLine().split(" ");
                words.addAll(Arrays.asList(data));
            }
            reader.close();

            String[] wordsArray = new String[words.size()];
            for (int i = 0; i < wordsArray.length; i++) {
                wordsArray[i] = words.get(i);
            }


            StringBuilder result = getLine(wordsArray);
            System.out.println(result.toString());

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length==0) return new StringBuilder("");

        StringBuilder sb = new StringBuilder();
        Arrays.sort(words);
        Pair pair = new Pair(words);


        for (int i = 0; i < words.length; i++) {
            char aLastchar;
            if (i==0){
                sb.append(words[0]);
                pair.remove(getFirstChar(words[0]), words[0]);
            }

            aLastchar = sb.toString().toLowerCase().charAt(sb.length()-1);

            if (pair.contains(aLastchar, pair.getKey(aLastchar))){
                sb.append(" ");
                sb.append(pair.getKey(aLastchar));
                pair.remove(aLastchar, pair.getKey(aLastchar));
            }
        }
        sb.append(" " + pair.getOther());
        return sb;
    }

    public static Character getFirstChar(String string){
        return string.toLowerCase().charAt(0);
    }

    public static class Pair{
        public ArrayList<Character> key = new ArrayList<>();
        public ArrayList<String> value = new ArrayList<>();

        public Pair(String[] words) {
            for (int i = 0; i < words.length; i++) {
                key.add(words[i].toLowerCase().charAt(0));
                value.add(words[i]);
            }
        }

        public char getKey(int i) {
            return key.get(i);
        }

        public String getKey(char c){
            if (key.contains(c)){
                for (int i = 0; i < key.size(); i++) {
                    if (key.get(i)==c)
                        return value.get(i);
                }
            }else
                return null;
            return null;
        }

        public String getOther(){
            String result = "";
            for (String s : value) {
                result += s + " ";
            }
            return result.trim();
        }
        public String getValue(int i) {
            return value.get(i);
        }

        public void remove(Character character, String string){
            key.remove(character);
            value.remove(string);
        }

        public boolean contains(Character character, String string){
            if (key.contains(character) && value.contains(string)) return true;
            return false;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            int i = 0;
            for (String s : value) {
                if (i==0) {
                    result.append(key.get(i) + "=");
                    result.append(s);
                }else {
                    result.append(", ");
                    result.append(key.get(i) + "=");
                    result.append(s);
                }
                i++;
            }
            return "[" + result.toString() + "]";
        }
    }
}
