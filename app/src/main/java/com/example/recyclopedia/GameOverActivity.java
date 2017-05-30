package com.example.recyclopedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GameOverActivity extends AppCompatActivity {

    // initiliaze the views for this activity
    TextView go_textview;
    TextView score_textview;
    Button home_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_game_over));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // specify the design for the UI objects
        go_textview = (TextView) findViewById(R.id.game_over);
        score_textview = (TextView) findViewById(R.id.total_score);
        home_btn = (Button) findViewById(R.id.button_done);

        Intent in = getIntent();//initialize an intent
        score_textview.setText("" + in.getIntExtra("score", 0));    // since the game is already over, post the score

        MainActivity.doneItems = new ArrayList<Integer>();

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);    // the button will redirect to the Home Activity
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });

    }

}
