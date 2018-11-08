package com.example.john.buscaminas;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.john.buscaminas.db.GameDB;
import com.example.john.buscaminas.db.User;

import java.util.List;

public class CreateUserActivity extends AppCompatActivity {
    private TextInputEditText alias,firstName,lastName;
    GameDB db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = GameDB.getDatabase(this);
        setContentView(R.layout.activity_user_creation);
        alias = findViewById(R.id.aliasInputText);
        firstName = findViewById(R.id.firstNameInputText);
        lastName = findViewById(R.id.lastNameInputText);
    }

    public void create(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User();
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setNickName(alias.getText().toString());
                List<User> users = db.userDao().getAll();
                
                db.userDao().insert(user);
            }
        }).start();
    }
}
