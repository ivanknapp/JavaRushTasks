package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Model {

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score;
    protected int maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    private void addTile(){
        ArrayList<Tile> list = getEmptyTiles();
        if (list != null && !list.isEmpty()) {
            int newValue = Math.random() < 0.9 ? 2 : 4;
            Tile tile = list.get((int) (list.size() * Math.random()));
            tile.value = newValue;
        }
    }

    private ArrayList<Tile> getEmptyTiles(){
        ArrayList<Tile> list = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()){
                    list.add(gameTiles[i][j]);
                }
            }
        }
        return list;
    }

    public void resetGameTiles(){
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        this.score = 0;
        this.maxTile = 2;
        addTile();
        addTile();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private boolean compressTiles(Tile[] tiles){
        boolean result = false;
        int temp;
        for (int j = 0; j < tiles.length; j++) {
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].value == 0) {
                    if (tiles[i+1].value != 0) {
                        temp = tiles[i + 1].value;
                        tiles[i + 1].value = tiles[i].value;
                        tiles[i].value = temp;
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean result = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value > 0) {
                if (tiles[i].value == tiles[i + 1].value) {
                    tiles[i].value = tiles[i].value * 2;
                    //увеличиваем счёт
                    this.score += tiles[i].value;
                    //если полученная плитка в результате слияния больше максимального веса
                    //то изменяем максВес на текущий
                    if (tiles[i].value > maxTile)
                        maxTile = tiles[i].value;
                    tiles[i + 1].value = 0;
                    compressTiles(tiles);
                    result = true;
                }
            }
        }
        return result;
    }

    public void left(){
        if (isSaveNeeded){
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (int i = 0; i < gameTiles.length; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])){
                isChanged = true;
            }
        }
        if (isChanged)
            addTile();

        isSaveNeeded = true;
    }
    public void right() {
        saveState(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        left();
        mirror(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);


    }
    public void up(){
        saveState(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
    }
    public void down(){
        saveState(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
    }

    private void rotate(Tile[][] tiles) {
        Tile b;
        for (int i = 0; i < tiles.length / 2; i++)
            for (int j = i; j < tiles.length - 1 - i; j++) {
                b = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[tiles.length - j - 1][i];
                gameTiles[tiles.length - j - 1][i] = gameTiles[tiles.length - i - 1][tiles.length - j - 1];
                gameTiles[tiles.length - i - 1][tiles.length - j - 1] = gameTiles[j][tiles.length - i - 1];
                gameTiles[j][tiles.length - i - 1] = b;
            }
    }

    private void mirror(Tile[][] tiles) {
        Tile temp ;
        for (int j = 0; j < tiles.length; j++) {
            for (int i = 0; i < tiles[i].length / 2; i++) {
                temp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[i][tiles.length -j - 1];
                gameTiles[i][gameTiles[i].length -j - 1] = temp;
            }
        }
    }

    public boolean canMove(){
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length-1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j+1].value)
                    return true;
            }
        }

        for (int i = 0; i < gameTiles.length-1; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i+1][j].value)
                    return true;
            }
        }
        return false;
    }

    private void saveState(Tile[][] state){

        Tile[][] temp = new Tile[state.length][state[0].length];

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                temp[i][j] = new Tile(state[i][j].value);
            }
        }
        previousStates.push(temp);

        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback(){
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            score = previousScores.pop();
            gameTiles = previousStates.pop();
        }

    }

    public void randomMove(){
        int n = ((int)(Math.random()*100)) % 4;

        switch (n){
            case 0 : left();break;
            case 1 : right();break;
            case 2 : up();break;
            case 3 : down();break;
        }
    }

    public boolean hasBoardChanged(){

        Tile[][] temp = previousStates.peek();
        int currentSum = 0;
        int previousSum = 0;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                currentSum += gameTiles[i][j].value;
                previousSum += temp[i][j].value;
            }
        }
        return currentSum != previousSum;
    }

    public MoveEfficiency getMoveEfficiency(Move move){

        move.move();

        MoveEfficiency result = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if (!hasBoardChanged())
            result = new MoveEfficiency(-1, 0, move);

        rollback();
        return result;
    }

    private int getCountEmptyTiles(Tile[][] tiles){
        int counter = 0;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j].isEmpty())
                    counter++;
            }
        }

        return counter;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4,Collections.reverseOrder());

        for (int i = 0; i < 4; i++) {
            switch (i){
                case 0 : priorityQueue.offer(getMoveEfficiency(this::left));break;
                case 1 : priorityQueue.offer(getMoveEfficiency(this::right));break;
                case 2 : priorityQueue.offer(getMoveEfficiency(this::up));break;
                case 3 : priorityQueue.offer(getMoveEfficiency(this::down));break;
            }
        }

        priorityQueue.peek().getMove().move();

    }
}
