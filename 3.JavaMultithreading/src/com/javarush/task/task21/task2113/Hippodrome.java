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

    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    };

    public void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    };

    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                move();
                print();
                Thread.sleep(200);
            }
        }catch (InterruptedException e){

        }
    };

    public Horse getWinner(){
/*        Horse winnerHorse = game.getHorses().get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > winnerHorse.getDistance()){
                winnerHorse = horse;
            }
        }
        return winnerHorse;*/

        double max = Integer.MIN_VALUE;
        Horse horse1 = new Horse("1",0,0);
        for (Horse horse : horses)
        {
            if (horse.distance > max) {
                max = horse.distance;
                horse1 = horse;
            }
        }
        return horse1;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args){
        game = new Hippodrome();
        game.getHorses().add(new Horse("Золотце",3,0));
        game.getHorses().add(new Horse("Проворная",3,0));
        game.getHorses().add(new Horse("Белуха",3,0));
        game.run();
        game.printWinner();


    }

}
