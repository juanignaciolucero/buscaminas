package com.example.john.buscaminas;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.TextView;


public class PlayActivity extends Activity {
    GridView gridView;
    GridAdapter gridAdapter;
    Chronometer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        gridView = findViewById(R.id.msgridView);
        gridView.setNumColumns(MineSweeper.GRID_WIDTH);
        gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);
        TextView bombCounter = (TextView) findViewById(R.id.mineCounter);
        bombCounter.setText(Integer.toString(MineSweeper.BOMBS));
        t = findViewById(R.id.timeCounter);
        t.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long time = SystemClock.elapsedRealtime() - cArg.getBase();
                int s= (int)time /1000 ;

                cArg.setText(Integer.toString(s));
            }
        });
        t.setBase(SystemClock.elapsedRealtime());
        t.setTextSize(36);
        t.start();
    }
}
