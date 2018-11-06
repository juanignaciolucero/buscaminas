package com.example.john.buscaminas;

import android.content.Context;

import java.util.Random;

public class GridModel {

    private static Cell[][] matrix;
    private Context context;

    GridModel(int width, int height, int bombs, Context context) {
        this.context = context;
        createGrid(width, height, bombs);

    }

    private void createGrid(int width, int height, int bombs) {
        Cell[][] matrix = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = new Cell(context,null, j * MineSweeper.GRID_WIDTH + i);
                matrix[i][j] = cell;
            }
        }
        plantBombs(matrix, width, height, bombs);
        calcNeighbors(matrix, width, height);
        this.matrix = matrix;
    }

    private void calcNeighbors(Cell[][] matrix, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j].setNeighbors(neighbors(i, j, matrix, width, height));
            }
        }
    }

    private int neighbors(int x, int y, Cell[][] matrix, int width, int height) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i >= 0 &&
                        x + i < width &&
                        y + j >= 0 &&
                        y + j < height &&
                        !(j==0 && i ==0)) {
                    if (matrix[x + i][y + j].isBomb()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void plantBombs(Cell[][] matrix, int width, int height, int bombs) {
        Random r = new Random();
        int x, y;
        while ( bombs > 0) {
            x = r.nextInt(width);
            y = r.nextInt(height);
            if (!matrix[x][y].isBomb()) {
                matrix[x][y].setBomb();
                bombs--;
            }
        }
    }

    public Cell[][] getGrid() {
        return this.matrix;
    }
}
