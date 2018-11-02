package com.example.john.buscaminas;

import android.content.Context;

public class MineSweeper {
    private static MineSweeper singletone;
    protected static int GRID_HEIGHT;
    protected static int GRID_WIDTH;
    protected static int BOMBS;
    protected static Cell[][] MATRIZ;


    public static MineSweeper getInstance(){
        if(singletone == null){
            singletone = new MineSweeper();
        }
        return singletone;
    }
    public int getGRID_HEIGHT() {
        return GRID_HEIGHT;
    }

    public void setGRID_HEIGHT(int GRID_HEIGHT) {
        this.GRID_HEIGHT = GRID_HEIGHT;
    }

    public int getGRID_WIDTH() {
        return GRID_WIDTH;
    }

    public void setGRID_WIDTH(int GRID_WIDTH) {
        this.GRID_WIDTH = GRID_WIDTH;
    }

    public int getBOMBS() {
        return BOMBS;
    }

    public void setBOMBS(int BOMBS) {
        this.BOMBS = BOMBS;
    }
    public void createGrid(Context context){
        GridModel gridModel = new GridModel(this.GRID_WIDTH,this.GRID_HEIGHT,this.BOMBS,context);
        this.MATRIZ = gridModel.getGrid();

    }
}
