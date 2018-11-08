package com.example.john.buscaminas.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {
    @PrimaryKey(autoGenerate = true)
    int gid;
    @ColumnInfo
    int user;
    @ColumnInfo
    int gameDif;
    @ColumnInfo
    int time;
}
