package com.example.recyclopedia;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    //Initialize all things that we will be using later.
    ArrayList<Game> gameList = new ArrayList<Game>();
    Game item;

    int rand;
    int score;
    int counter;

    Button bio_button;
    Button nonbio_button;
    Button rec_button;

    TextView game_name;

    ImageView game_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_game));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bio_button = (Button) findViewById(R.id.button_bio);
        nonbio_button = (Button) findViewById(R.id.button_nonbio);
        rec_button = (Button) findViewById(R.id.button_rec);
        game_name = (TextView) findViewById(R.id.game_name);
        game_img = (ImageView) findViewById(R.id.game_image);

        /* Retrieval of a question part */
        gameList = MainActivity.getGameList();              // get an arraylist containing all questions from the databse
        rand = 0 + (int)(Math.random() * ((13 - 0) + 1));

        while(!MainActivity.doneItems.isEmpty() && MainActivity.doneItems.contains(rand)) {
            rand = 0 + (int)(Math.random() * ((13 - 0) + 1));   // get a random number
        }
        MainActivity.doneItems.add(rand);

        Intent intent = getIntent();                        // set an intent
        score = intent.getIntExtra("score", 0);             // retrieve the current score as well as the counter on how many times
        counter = intent.getIntExtra("counter", 0);         // the player has played

        item = gameList.get(rand);                          // using the random number we got earlier, we will now select an item from the retrieved arraylist

        game_name.setText(item.getGameItem());          //  set the text of the text view, describing the item shown

        Resources res = getResources();                     // the following code displays an image based on the file name of the image that was retrieved from the database
        String img_name = item.getGameImage();
        int resID = res.getIdentifier(img_name , "drawable", getPackageName());
        game_img.setImageResource(resID);

        /* End of the retrieval of a question part */

        ++counter;                                          // increment the counter

        // Biodegradable button
        bio_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), CheckActivity.class);   // when a player clicks this button, it will redirect to the checkactivity Activity
                in.putExtra("counter", counter); // pass the counter
                in.putExtra("score", score);     // pass the score
                in.putExtra("user_answer", 1);      // pass the answer -- 1 stands for biodegradable
                in.putExtra("real_answer", item.getGameItemType()); // pass the correct answer, based on the retrieved object
                in.putExtra("details", item.getGameDetails());      // pass the details
                in.putExtra("img", item.getGameImage());        //pass the image (to be used as well)
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });

        // Non-biodegradable button

        nonbio_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), CheckActivity.class);   // when a player clicks this button, it will redirect to the checkactivity Activity
                in.putExtra("counter", counter); // pass the counter
                in.putExtra("score", score);     // pass the score
                in.putExtra("user_answer", 2);  // pass the answer -- 2 stands for non-biodegradable
                in.putExtra("real_answer", item.getGameItemType()); // pass the correct answer, based on the retrieved object
                in.putExtra("details", item.getGameDetails());      // pass the details
                in.putExtra("img", item.getGameImage());            //pass the image (to be used as well)
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });

        rec_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), CheckActivity.class);   // when a player clicks this button, it will redirect to the checkactivity Activity
                in.putExtra("counter", counter);    // pass the counter
                in.putExtra("score", score);        // pass the score
                in.putExtra("user_answer", 3);      // pass the answer -- 3 stands for recyclable
                in.putExtra("real_answer", item.getGameItemType()); // pass the correct answer, based on the retrieved object
                in.putExtra("details", item.getGameDetails());  // pass the details
                in.putExtra("img", item.getGameImage());        //pass the image (to be used as well)
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });



    }

}
