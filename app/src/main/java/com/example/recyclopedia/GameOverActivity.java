package com.example.recyclopedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mariz on 12/10/2016.
 */
public class GameOverActivity extends Activity {
    TextView go_textview;
    TextView score_textview;
    Button home_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);

        go_textview = (TextView) findViewById(R.id.game_over);
        score_textview = (TextView) findViewById(R.id.score_text);
        home_btn = (Button) findViewById(R.id.home_btn);

        Intent in = getIntent();

        score_textview.setText("" + in.getIntExtra("score", 0));

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gameover_activity, menu);
        return true;
    }

}
