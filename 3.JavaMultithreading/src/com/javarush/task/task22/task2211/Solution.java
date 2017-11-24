package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251. Смотри файл example.txt для примера.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
В результате во втором файле должен быть читабельный текст.


Требования:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        byte[] bytes = new byte[fileInputStream.available()];
        int i = fileInputStream.read(bytes);
        String string = new String(bytes, windows1251);
        outputStream.write(string.getBytes(utf8));

        fileInputStream.close();
        outputStream.close();
    }
}
