package com.example.john.buscaminas.db;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface GameDao {
    @Query("SELECT * FROM Game")
    List<Game> getAll();

    @Query("SELECT * FROM Game WHERE gid IN (:gameIds)")
    List<Game> loadAllByIds(int[] gameIds);

    @Query("SELECT * FROM Game INNER JOIN user ON Game.user = User.uid WHERE Game.gameDif=gameDif ORDER BY Game.time  ASC ")
    List<Game> findGameByDiff(int gameDiff);

    @Insert
    void insertAll(Game... games);

    @Delete
    void delete(Game game);
}
