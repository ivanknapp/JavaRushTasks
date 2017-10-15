package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution extends Statics{
    public static List<String> lines = new ArrayList<String>();

    static {
        try (FileInputStream fileInputStream = new FileInputStream(Statics.FILE_NAME)){
            System.out.println("available bytes: " + fileInputStream.available());
            String tmp = "";
            while (fileInputStream.available()>0){
                int data = fileInputStream.read();
                if (data == 10) {
                    lines.add(tmp);
                    tmp = "";
                    continue;
                }
                else if (data == 13)
                    continue;
                else
                    tmp+=(char)data;
                if (fileInputStream.available() == 0)
                    lines.add(tmp);
            }
        }catch (Exception e) {}
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
