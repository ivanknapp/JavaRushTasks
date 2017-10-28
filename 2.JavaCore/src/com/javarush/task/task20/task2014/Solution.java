package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        System.out.println(new Solution(4));

        FileOutputStream fileOutputStream = new FileOutputStream("c:/result.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        Solution savedObject = new Solution( 5);
        outputStream.writeObject(savedObject);

        fileOutputStream.close();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("c:/result.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        Object object =  inputStream.readObject();
        Solution loadedObject = (Solution)object;

        fileInputStream.close();
        inputStream.close();

        System.out.println(savedObject.string.equals(loadedObject.string));


    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
