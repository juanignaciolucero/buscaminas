package com.example.john.buscaminas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view){
        Intent play = new Intent(this,DifficultySelection.class);
        startActivity(play);
    }

    public void hall_of_fame(View view){
        Intent bests = new Intent(this,Bests.class);
        startActivity(bests);
    }

    public void exit(View view){
        finish();
    }
}
