package com.example.john.buscaminas;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.john.buscaminas.db.GameDB;
import com.example.john.buscaminas.util.MineSweeper;

import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameDB db = Room.databaseBuilder(getApplicationContext(),GameDB.class,"game_db")
                .allowMainThreadQueries()
                .build();
        MineSweeper.setDB(db);
    }

    public void play(View view){
        Intent play = new Intent(this,UserSelectionActivity.class);
        startActivity(play);
    }

    public void hall_of_fame(View view){
        Intent bests = new Intent(this,BestsActivity.class);
        startActivity(bests);
    }

    public void exit(View view){
        finish();
    }
}
