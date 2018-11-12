package com.example.john.buscaminas;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.john.buscaminas.util.GridAdapter;
import com.example.john.buscaminas.util.MineSweeper;


public class PlayActivity extends AppCompatActivity {
    GridView gridView;
    GridAdapter gridAdapter;
    Chronometer t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MineSweeper.setActivity(this);
        setContentView(R.layout.activity_play);
        gridView = findViewById(R.id.msgridView);
        gridView.setNumColumns(MineSweeper.GRID_WIDTH);
        gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);
        TextView bombCounter = findViewById(R.id.mineCounter);
        bombCounter.setText(Integer.toString(MineSweeper.BOMBS));
        t = findViewById(R.id.timeCounter);
        t.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long time = SystemClock.elapsedRealtime() - cArg.getBase();
                int s = (int) time / 1000;
                cArg.setText(Integer.toString(s));
            }
        });
        t.setBase(SystemClock.elapsedRealtime());
        t.start();
    }

    public void endLose() {
        createMsg(false).show();
    }

    public void endWin() {
        createMsg(true).show();//TODO SAVE IN DB
    }

    public AlertDialog.Builder createMsg(Boolean win) {
        TextView mensaje = new TextView(this);
        mensaje.setText(win ? R.string.win : R.string.lose);
        mensaje.setTextSize(36f);
        mensaje.setGravity(Gravity.CENTER_HORIZONTAL);
        return new AlertDialog.Builder(this)
                .setView(mensaje)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        dialog.cancel();
                    }
                });
    }
}
