package com.example.john.buscaminas.util;

import android.content.Context;

import com.example.john.buscaminas.PlayActivity;
import com.example.john.buscaminas.db.Game;
import com.example.john.buscaminas.db.GameDB;
import com.example.john.buscaminas.view.Cell;

public class MineSweeper {
    private static MineSweeper INSTANCE;
    private int GRID_HEIGHT;
    private int GRID_WIDTH;
    private int BOMBS;
    private int bombsLeft;
    private Cell[][] MATRIX;
    private boolean ENDED;
    private PlayActivity activity;
    private int user;
    private GameDB DB;
    private int dif;


    public static MineSweeper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MineSweeper();
        }
        return INSTANCE;
    }

    MineSweeper() {
        this.ENDED = false;
    }

    public void click(int position) {
        int x = position % this.GRID_WIDTH;
        int y = position / this.GRID_WIDTH;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i >= 0 &&
                        x + i < this.GRID_WIDTH &&
                        y + j >= 0 &&
                        y + j < this.GRID_HEIGHT &&
                        !(i == 0 && j == 0)) {
                    this.MATRIX[x + i][y + j].onClick(this.MATRIX[x][y]);
                }
            }
        }
    }

    public void endGame() {
        this.ENDED = true;
        for (int i = 0; i < this.GRID_WIDTH; i++) {
            for (int j = 0; j < this.GRID_HEIGHT; j++) {
                this.MATRIX[i][j].end();
            }
        }
        this.activity.endLose();
    }

    public GameDB getDB() {
        return this.DB;
    }

    public void setDB(GameDB DB) {
        this.DB = DB;
    }

    public void checkForWin() {
        Boolean exit = false;
        int x = 0;
        int y = 0;
        while (y < this.GRID_HEIGHT && !exit) {
            while (x < this.GRID_WIDTH && !exit) {
                if (!this.MATRIX[x][y].isRevealed() && !this.MATRIX[x][y].isBomb()) {
                    exit = true;
                }
                x++;
            }
            x = 0;
            y++;
        }
        if (!exit) {
            activity.endWin();
        }
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void saveGame(Game game) {
        this.DB.gameDao().insert(game);
    }

    public int getGRID_HEIGHT() {
        return this.GRID_HEIGHT;
    }

    public void setGRID_HEIGHT(int GRID_HEIGHT) {
        this.GRID_HEIGHT = GRID_HEIGHT;
    }

    public int getGRID_WIDTH() {
        return this.GRID_WIDTH;
    }

    public void setGRID_WIDTH(int GRID_WIDTH) {
        this.GRID_WIDTH = GRID_WIDTH;
    }

    public int getBOMBS() {
        return this.BOMBS;
    }

    public void setBOMBS(int BOMBS) {
        this.BOMBS = BOMBS;
        this.bombsLeft = BOMBS;
    }

    public void setENDED(boolean ended) {
        this.ENDED = ended;
    }

    public void createGrid(Context context) {
        GridModel gridModel = new GridModel(GRID_WIDTH, GRID_HEIGHT, BOMBS, context);
        this.MATRIX = gridModel.getGrid();
    }

    public PlayActivity getActivity() {
        return this.activity;
    }

    public void setActivity(PlayActivity activity) {
        this.activity = activity;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }

    public boolean isEnded() {
        return this.ENDED;
    }

    public int getUser() {
        return this.user;
    }

    public int getDif() {
        return this.dif;
    }

    public Cell[][] getMatrix() {
        return this.MATRIX;
    }

    public int getBombsLeft() {
        return bombsLeft;
    }

    public void setBombsLeft(int bombsLeft) {
        this.bombsLeft = bombsLeft;
        activity.setMinesLeft(bombsLeft);
    }
}
