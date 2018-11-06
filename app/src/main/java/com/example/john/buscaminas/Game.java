package com.example.john.buscaminas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {
    @PrimaryKey
    int uid;
    @ColumnInfo
    int user;
    @ColumnInfo
    int gameDif;
    @ColumnInfo
    int time;
}
