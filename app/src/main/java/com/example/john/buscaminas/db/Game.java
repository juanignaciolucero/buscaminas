package com.example.john.buscaminas.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "uid",
        childColumns = "user",
        onDelete = CASCADE))
public class Game {

    @PrimaryKey(autoGenerate = true)
    int gid;
    @ColumnInfo
    int user;
    @ColumnInfo
    int gameDif;
    @ColumnInfo
    int time;
    public Game(int user, int gameDif, int time){
        this.user =user;
        this.gameDif=gameDif;
        this.time=time;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getGameDif() {
        return gameDif;
    }

    public void setGameDif(int gameDif) {
        this.gameDif = gameDif;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
