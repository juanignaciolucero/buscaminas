package com.example.john.buscaminas.util;

import android.content.Context;

import com.example.john.buscaminas.PlayActivity;
import com.example.john.buscaminas.db.Game;
import com.example.john.buscaminas.db.GameDB;
import com.example.john.buscaminas.view.Cell;

public class MineSweeper {
    private static MineSweeper INSTANCE;
    public static int GRID_HEIGHT;
    public static int GRID_WIDTH;
    public static int BOMBS;
    public static Cell[][] MATRIX;
    public static boolean ENDED;
    private static PlayActivity activity;
    public static int user;
    public static GameDB DB;
    public static int dif;


    public static MineSweeper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MineSweeper();
        }
        return INSTANCE;
    }

    MineSweeper() {
        ENDED = false;
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
        activity.endLose();
    }

    public static GameDB getDB() {
        return DB;
    }

    public static void setDB(GameDB DB) {
        MineSweeper.DB = DB;
    }

    public static void checkForWin() {
        Boolean exit = false;
        int x = 0;
        int y = 0;
        while (y < MineSweeper.GRID_HEIGHT && !exit) {
            while (x < MineSweeper.GRID_WIDTH && !exit) {
                if (!MineSweeper.MATRIX[x][y].isRevealed() && !MineSweeper.MATRIX[x][y].isBomb()) {
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

    public static void setUser(int user) {
        MineSweeper.user = user;
    }

    public static void saveGame(Game game) {
        DB.gameDao().insert(game);
    }

    public int getGRID_HEIGHT() {
        return GRID_HEIGHT;
    }

    public void setGRID_HEIGHT(int GRID_HEIGHT) {
        MineSweeper.GRID_HEIGHT = GRID_HEIGHT;
    }

    public int getGRID_WIDTH() {
        return GRID_WIDTH;
    }

    public void setGRID_WIDTH(int GRID_WIDTH) {
        MineSweeper.GRID_WIDTH = GRID_WIDTH;
    }

    public int getBOMBS() {
        return BOMBS;
    }

    public void setBOMBS(int BOMBS) {
        MineSweeper.BOMBS = BOMBS;
    }

    public void setENDED(boolean ended) {
        ENDED = ended;
    }

    public void createGrid(Context context) {
        GridModel gridModel = new GridModel(GRID_WIDTH, GRID_HEIGHT, BOMBS, context);
        MATRIX = gridModel.getGrid();
    }

    public PlayActivity getActivity() {
        return activity;
    }

    public static void setActivity(PlayActivity activity) {
        MineSweeper.activity = activity;
    }

    public void setDif(int dif) {
        MineSweeper.dif=dif;
    }
}
