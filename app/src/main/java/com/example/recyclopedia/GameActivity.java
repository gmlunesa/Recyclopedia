package com.example.recyclopedia;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
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
    int score;
    int counter;
    Game item;

    Button bio_button;
    Button nonbio_button;
    Button rec_button;

    TextView item_textview;

    ImageView img_imageview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);


        bio_button = (Button) findViewById(R.id.button1);
        nonbio_button = (Button) findViewById(R.id.button2);
        rec_button = (Button) findViewById(R.id.button3);

        item_textview = (TextView) findViewById(R.id.itemView);

        img_imageview = (ImageView) findViewById(R.id.imageView);

        //setQuestion();
        gameList = MainActivity.getGameList();
        rand = 0 + (int)(Math.random() * ((2 - 0) + 1));

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);
        counter = intent.getIntExtra("counter", 0);

        item = gameList.get(rand);

        item_textview.setText(item.getGameItem());

        Resources res = getResources();
        String img_name = item.getGameImage();
        int resID = res.getIdentifier(img_name , "drawable", getPackageName());
        img_imageview.setImageResource(resID);

        Log.d("user details", ": " + item.getGameDetails());

        ///// end of setting the question page

        ++counter;

        // Biodegradable button
        bio_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), CheckActivity.class);
                in.putExtra("counter", counter);
                in.putExtra("score", score);
                in.putExtra("user_answer", 1);
                in.putExtra("real_answer", item.getGameItemType());
                in.putExtra("details", item.getGameDetails());
                in.putExtra("img", item.getGameImage());
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });

        // Non-biodegradable button

        nonbio_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), CheckActivity.class);
                in.putExtra("counter", counter);
                in.putExtra("score", score);
                in.putExtra("user_answer", 2);
                in.putExtra("real_answer", item.getGameItemType());
                in.putExtra("details", item.getGameDetails());
                in.putExtra("img", item.getGameImage());
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });

        rec_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), CheckActivity.class);
                in.putExtra("counter", counter);
                in.putExtra("score", score);
                in.putExtra("user_answer", 3);
                in.putExtra("real_answer", item.getGameItemType());
                in.putExtra("details", item.getGameDetails());
                in.putExtra("img", item.getGameImage());
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });




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
        score = intent.getIntExtra("score", 0);
        counter = intent.getIntExtra("counter", 0);

        item = gameList.get(rand);

        item_textview.setText(item.getGameItem());

    }





}
