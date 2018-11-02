package com.example.john.buscaminas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class PlayActivity extends Activity {
    GridView gridView;
    GridAdapter gridAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        gridView = (GridView) findViewById(R.id.msgridView);
        gridView.setNumColumns(MineSweeper.GRID_WIDTH);
        gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);
    }
}
