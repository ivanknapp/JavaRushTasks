package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thread : threads) {
            switch (thread.getState()){
                case NEW: thread.start(); break;
                case RUNNABLE: thread.isInterrupted(); break;
                case WAITING: thread.interrupt(); break;
                case BLOCKED: thread.interrupt(); break;
                case TIMED_WAITING: thread.interrupt(); break;
                case TERMINATED: System.out.println(thread.getPriority()); break;
            }

        }
    }

    public static  void text(int[] ints){
        for (int i = 0; i < ints.length; i++) {
            switch (ints[i]){
                case (0): System.out.println(1); break;
                case (1): System.out.println(2); break;
                case (2): System.out.println(3); break;
                case (3): System.out.println(4); break;
                case (4): System.out.println(5); break;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0,2,3,4,5};
        text(ints);
    }
}
