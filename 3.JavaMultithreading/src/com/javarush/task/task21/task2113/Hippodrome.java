package com.javarush.task.task21.task2113;

import java.util.LinkedList;
import java.util.List;

public class Hippodrome{
    List<Horse> horses = new LinkedList<>();
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public Hippodrome() {
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move(){};
    public void print(){};
    public void run(){
        try {
            for (int i = 0; i < 100; i++) {
                move();
                print();
                Thread.sleep(200);
            }
        }catch (InterruptedException e){

        }
    };

    public static void main(String[] args){
        game = new Hippodrome();
        game.horses.add(new Horse("Золотце",3,0));
        game.horses.add(new Horse("Проворная",3,0));
        game.horses.add(new Horse("Белуха",3,0));
    }

}
