package com.example.john.buscaminas.util;

import android.content.Context;

import com.example.john.buscaminas.view.Cell;

public class MineSweeper {
    private static MineSweeper INSTANCE;
    public static int GRID_HEIGHT;
    public static int GRID_WIDTH;
    public static int BOMBS;
    public static Cell[][] MATRIX;
    public static boolean ENDED;


    public static MineSweeper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MineSweeper();
        }
        return INSTANCE;
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
                    MATRIX[x + i][y + j].onClick(MATRIX[x][y]);
                }
            }
        }
    }

    public static void endGame() {
        ENDED = true;
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                MATRIX[i][j].end();
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
        this.MATRIX = gridModel.getGrid();
    }

}
