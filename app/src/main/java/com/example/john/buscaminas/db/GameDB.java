package com.example.john.buscaminas.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Game.class, User.class}, version = 2 ,exportSchema = false)
public abstract class GameDB extends RoomDatabase {

    private static GameDB INSTANCE;

    public abstract GameDao gameDao();

    public abstract UserDao userDao();
    public static GameDB getDB(final Context context) {
        if (INSTANCE == null) {
           synchronized (GameDB.class){
               if(INSTANCE==null){
                   INSTANCE = Room.databaseBuilder(context.getApplicationContext(),GameDB.class,"game_db")
                           .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                           .build();
               }
           }
        }
        return INSTANCE;
    }
}
