package com.example.john.buscaminas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

public class UserSelectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);
        Spinner spinner = findViewById(R.id.spinner);
    }
    public void createUser(View view){}
    public void play(View view){}
}
