package com.javarush.task.task26.task2605;

public class test {
    static int x = 0;
    int y = 1;
    public static void main(String[] args) {

    }

     private static void  info(int x , int y){
        System.out.println("solution");
    }

    public void say( int grey) throws Exception {
        System.out.println("sol say");
        throw new Exception();
    }


/*    public class  B extends  test{
        @Override
        void info() {
            System.out.println("B");
        }
    }*/
}
