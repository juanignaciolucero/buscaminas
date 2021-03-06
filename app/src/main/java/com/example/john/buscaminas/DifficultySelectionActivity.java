package com.example.john.buscaminas;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.example.john.buscaminas.util.MineSweeper;

public class DifficultySelectionActivity extends AppCompatActivity {
    private MineSweeper core;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_selection);
        core = MineSweeper.getInstance();
    }

    public void select(View view) {

        int height=0;
        int width=0;
        int bombs=0;
        int dif=0;
        switch (view.getId()) {
            case R.id.easy_diff_button:
                height=8;
                width=8;
                bombs=10;
                break;
            case R.id.medium_diff_button:
                height=16;
                width=16;
                bombs=40;
                dif=1;
                break;
            case R.id.hard_diff_button:
                height=16;
                width=30;
                bombs=99;
                dif=2;
                break;
        }
        core.setGRID_HEIGHT(height);
        core.setGRID_WIDTH(width);
        core.setBOMBS(bombs);
        core.setENDED(false);
        core.setDif(dif);
        core.createGrid(this);
        Intent play = new Intent(this, PlayActivity.class);
        startActivity(play);
    }
}
