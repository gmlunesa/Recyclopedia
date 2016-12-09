package com.example.recyclopedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mariz on 12/9/2016.
 */
public class GameActivity extends Activity {

    ArrayList<Game> gameList = new ArrayList<Game>();
    int rand;

    Button bio_button;
    Button nonbio_button;
    Button rec_button;

    TextView score_textview;
    TextView item_textview;

    ImageView img_imageview;
    private static final String TAG = "your activity name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);


        bio_button = (Button) findViewById(R.id.button1);
        nonbio_button = (Button) findViewById(R.id.button2);
        rec_button = (Button) findViewById(R.id.button3);

        item_textview = (TextView) findViewById(R.id.itemView);
        score_textview = (TextView) findViewById(R.id.scoreView);

        img_imageview = (ImageView) findViewById(R.id.imageView);

        setQuestion();


    }

    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game_activity, menu);
        return true;
    }


    public void setQuestion() {

        gameList = MainActivity.getGameList();
        rand = 0 + (int)(Math.random() * ((2 - 0) + 1));

        Intent intent = new Intent();
        int score = intent.getIntExtra("score", 0);
        int counter = intent.getIntExtra("counter", 0);

        Game item = gameList.get(rand);

        item_textview.setText(item.getGameItem());
        score_textview.setText("" + score);

        //Intent toBePassed = new Intent();


    }





}
