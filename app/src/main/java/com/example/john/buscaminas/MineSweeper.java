package com.example.john.buscaminas;

import android.content.Context;

public class MineSweeper {
    private static MineSweeper singletone;
    protected static int GRID_HEIGHT;
    protected static int GRID_WIDTH;
    protected static int BOMBS;
    protected static Cell[][] MATRIZ;
    protected static boolean ENDED;


    public static MineSweeper getInstance() {
        if (singletone == null) {
            singletone = new MineSweeper();
        }
        return singletone;
    }

    MineSweeper() {
        this.ENDED = false;
    }

    public static void click(int position) {
        int x = position % GRID_WIDTH;
        int y = position / GRID_WIDTH;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i >= 0 &&
                        x + i < GRID_WIDTH &&
                        y + j >= 0 &&
                        y + j < GRID_HEIGHT &&
                        !(i == 0 && j == 0)) {
                    MATRIZ[x + i][y + j].onClick(MATRIZ[x][y]);
                }
            }
        }
    }

    public static void endGame() {
        ENDED = true;
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                MATRIZ[i][j].end();
            }
        }
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

    public void setENDED(boolean ended) {
        this.ENDED = ended;
    }

    public void createGrid(Context context) {
        GridModel gridModel = new GridModel(this.GRID_WIDTH, this.GRID_HEIGHT, this.BOMBS, context);
        this.MATRIZ = gridModel.getGrid();
    }

}
