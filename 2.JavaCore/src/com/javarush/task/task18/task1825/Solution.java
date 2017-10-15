package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> fileNameList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                String fileName = reader.readLine();
                if (fileName.equals("end")) break;
                else fileNameList.add(fileName);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("BAD very BAD!!!!!!!!!");
            e.printStackTrace();
        }


        String[] fileNameArray = new String[fileNameList.size()];
        for (int i = 0; i < fileNameList.size(); i++) {
            fileNameArray[i] = fileNameList.get(i);
        }

        Arrays.sort(fileNameArray);

        try {

            for (String s : fileNameArray) {

                FileInputStream inputStream = new FileInputStream(s);
                // Создаем поток-записи-байт-в-файл
                FileOutputStream outputStream = new FileOutputStream(fileNameArray[0].substring(0, fileNameArray[0].lastIndexOf('.')),true);

                byte[] buffer = new byte[1000];

                while (inputStream.available() > 0) //пока есть еще непрочитанные байты
                {
                    // прочитать очередной блок байт в переменную buffer и реальное количество в count
                    int count = inputStream.read(buffer);
                    outputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
                }

                inputStream.close();
                outputStream.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        //File file = new File().createNewFile()

    }
}
