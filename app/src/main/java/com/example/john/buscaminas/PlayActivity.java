package com.example.john.buscaminas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class PlayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        GridView gridView =  findViewById(R.id.msgridView);
        gridView.setWillNotDraw(false);
        gridView.setNumColumns(MineSweeper.GRID_WIDTH);
        GridAdapter gridAdapter = new GridAdapter();
        gridView.setAdapter(gridAdapter);
    }
}
