package com.example.john.buscaminas;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.john.buscaminas.db.GameDB;
import com.example.john.buscaminas.db.User;

import java.util.ArrayList;
import java.util.List;

public class UserSelectionActivity extends AppCompatActivity {
    GameDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = GameDB.getDB(this);
        ArrayList<String> nicknames = new ArrayList<String>();
        List<User> users = db.userDao().getAll();
        for (User u : users){
            nicknames.add(u.getNickName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item, nicknames);
        setContentView(R.layout.activity_user_selection);
        adapter.notifyDataSetChanged();
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

    }
    public void createUser(View view){
        Intent createUser = new Intent(this,CreateUserActivity.class);
        startActivity(createUser);
    }
    public void play(View view){
        Intent difficultySelection = new Intent(this,DifficultySelectionActivity.class);
        startActivity(difficultySelection);
    }
}
