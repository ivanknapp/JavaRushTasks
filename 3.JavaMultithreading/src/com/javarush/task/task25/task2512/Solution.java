package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

/*    public Solution() {
        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Exception e) {
            uncaughtException(Thread.currentThread(), e);
        }
    }*/

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> list = new ArrayList<>();
        Throwable throwable = e;
        while (throwable != null){
            list.add(throwable);
            throwable = throwable.getCause();
        }
        Collections.reverse(list);
        list.forEach(k -> System.out.println(k));
    }

    public static void main(String[] args) throws Exception {
/*        Thread thread = new Thread();
        Thread.UncaughtExceptionHandler handler = new Solution();
        thread.setUncaughtExceptionHandler(handler);
        thread.start();*/
    }


}
