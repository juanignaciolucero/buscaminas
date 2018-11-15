package com.example.john.buscaminas;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.john.buscaminas.db.GameDB;
import com.example.john.buscaminas.db.User;
import com.example.john.buscaminas.util.MineSweeper;

import java.util.ArrayList;

public class UserSelectionActivity extends AppCompatActivity {
    private GameDB db;
    private Spinner spinner;
    private MineSweeper core;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = GameDB.getDB(this);
        core = MineSweeper.getInstance();
        setContentView(R.layout.activity_user_selection);
        ArrayAdapter<String> adapter = createAdapter();
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        spinner.setAdapter(createAdapter());
    }

    private ArrayAdapter<String> createAdapter() {
        ArrayList<String> nicknames = (ArrayList<String>) db.userDao().getAllNickNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item, nicknames);
        adapter.notifyDataSetChanged();
        return adapter;

    }

    public void createUser(View view) {
        Intent createUser = new Intent(this, CreateUserActivity.class);
        startActivity(createUser);
    }

    public void play(View view) {
        User user = db.userDao().findByAlias(spinner.getSelectedItem().toString());
        core.setUser(user.getUid());
        Intent difficultySelection = new Intent(this, DifficultySelectionActivity.class);
        startActivity(difficultySelection);
    }
}
