package com.javarush.task.task35.task3513;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame game = new JFrame();
        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450,500);
        game.setResizable(false);

        game.add(controller.getView());
        game.setLocationRelativeTo(null);
        game.setVisible(true);

    }

    public static void  print(Tile[][] tiles){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tiles[i][j].value + " ");
            }
            System.out.println();
        }
    }
}
