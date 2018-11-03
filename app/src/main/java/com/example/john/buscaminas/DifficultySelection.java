package com.example.john.buscaminas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class DifficultySelection extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_selection);
    }

    public void select(View view) {
        MineSweeper core = MineSweeper.getInstance();
        switch (view.getId()) {
            case R.id.easy_diff_button:
                core.setGRID_HEIGHT(8);
                core.setGRID_WIDTH(8);
                core.setBOMBS(10);
                core.createGrid(this);
                Log.e("Dificultad", "8");
                break;
            case R.id.medium_diff_button:
                core.setGRID_HEIGHT(16);
                core.setGRID_WIDTH(16);
                core.setBOMBS(40);
                core.createGrid(this);
                break;
            case R.id.hard_diff_button:
                core.setGRID_HEIGHT(16);
                core.setGRID_WIDTH(30);
                core.setBOMBS(99);
                core.createGrid(this);
                break;
        }

        Intent play = new Intent(this, PlayActivity.class);
        startActivity(play);
    }
}
