package com.example.john.buscaminas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.john.buscaminas.db.Game;
import com.example.john.buscaminas.db.GameDB;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class BestsActivity extends AppCompatActivity {
    private TableLayout tl;
    private GameDB db;
    private Context context= null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getApplicationContext();
        db = GameDB.getDB(context);
        setContentView(R.layout.activity_bests);
        tl = findViewById(R.id.tableLayout);
        populateTable(0);
    }

    public void showTable(View view) {
        int diff = 0;
        switch (view.getId()) {
            case R.id.easy_diff:
                diff = 0;
                break;
            case R.id.medium_diff:
                diff = 1;
                break;
            case R.id.hard_diff:
                diff = 2;
                break;
        }
        populateTable(diff);
    }

    private void populateTable(int diff) {
        TableRow tr = (TableRow) tl.getChildAt(0);
        tl.removeAllViews();
        tl.addView(tr);
        int white = Color.parseColor("#ffffff");
        List<Game> gameList = db.gameDao().findGameByDiff(diff);
        for (Game g : gameList) {

            tr = new TableRow(context);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

            TextView user = new TextView(context);
            user.setTextColor(white);
            user.setTypeface(null,Typeface.BOLD);
            user.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 36);
            user.setText(db.userDao().findById(g.getUser()).getNickName());
            user.setGravity(Gravity.CENTER_HORIZONTAL);


            TextView seconds = new TextView(context);
            seconds.setText(Integer.toString(g.getTime()));
            seconds.setTypeface(null,Typeface.BOLD);
            seconds.setTextColor(white);
            seconds.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 36);
            seconds.setGravity(Gravity.CENTER_HORIZONTAL);

            tr.addView(user,0);
            tr.addView(seconds,1);
            tl.addView(tr);
        }
    }
}
