package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {

    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            String[] w = loadWheelNamesFromDB();
            wheels = new ArrayList<>();
            try {
                if (w.length != 4) throw new IllegalArgumentException();
                for (int i = 0; i < w.length; i++) {
                    wheels.add(Wheel.valueOf(w[i]));
                }
            }catch (IllegalArgumentException e){
                throw e;
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
