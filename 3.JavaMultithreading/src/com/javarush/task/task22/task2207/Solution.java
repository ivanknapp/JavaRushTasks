package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder
3. Список result должен быть заполнен корректными парами согласно условию задачи.
4. В классе Solution должен содержаться вложенный класс Pair.
5. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            reader = new BufferedReader(new FileReader(fileName));

            ArrayList<String> words = new ArrayList<>();

            while (reader.ready()){
                String[] string = reader.readLine().split(" ");
                words.addAll(Arrays.asList(string));
            }
            reader.close();
            ArrayList<String> wordsCopy = new ArrayList<>(words);

//            System.out.println(words);

            for (String s : words) {
                wordsCopy.remove(s);
                String aReverseWord = new StringBuilder(s).reverse().toString();
                boolean b = wordsCopy.contains(aReverseWord);
                if (b){
                    Pair pair = new Pair();
                    pair.first = s;
                    pair.second = new StringBuilder(s).reverse().toString();
                    if (!result.contains(pair))
                        result.add(pair);
                    wordsCopy.remove(new StringBuilder(s).reverse().toString());
                }
            }

/*            for (Pair p : result) {
                System.out.println(p);
            }*/



        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
