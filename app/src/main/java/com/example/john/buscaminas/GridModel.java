package com.example.john.buscaminas;

import android.content.Context;

import java.util.Random;

public class GridModel {

    private static Cell[][] matriz;
    private static Context context;

    GridModel(int width, int height, int bombs, Context context) {
        this.context = context;
        createGrid(width, height, bombs);
    }

    private void createGrid(int width, int height, int bombs) {
        Cell[][] matriz = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = new Cell(context,null, j * MineSweeper.GRID_WIDTH + i);
                matriz[i][j] = cell;
            }
        }
        plantBombs(matriz, width, height, bombs);
        calcNeighbors(matriz, width, height);
        this.matriz = matriz;
    }

    private void calcNeighbors(Cell[][] matriz, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                matriz[i][j].setNeighbors(neighbors(i, j, matriz, width, height));
            }
        }
    }

    private int neighbors(int x, int y, Cell[][] matriz, int width, int height) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i >= 0 && x + i < width && y + j >= 0 && y + j < height) {
                    if (matriz[x + i][y + j].isBomb()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void plantBombs(Cell[][] matriz, int width, int height, int bombs) {
        Random r = new Random();
        Boolean salir = false;
        int x, y;
        while (!salir & bombs > 0) {
            x = r.nextInt(width);
            y = r.nextInt(height);
            if (!matriz[x][y].isBomb()) {
                matriz[x][y].setBomb();
                bombs--;
            }
        }
    }

    public Cell[][] getGrid() {
        return this.matriz;
    }
}
