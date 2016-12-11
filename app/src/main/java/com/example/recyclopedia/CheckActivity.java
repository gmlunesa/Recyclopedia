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

/**
 * Created by Mariz on 12/10/2016.
 */
public class CheckActivity extends Activity {

    // initialize the UI objects
    TextView answer_textview;
    TextView details_textview;
    ImageView img_imageview;

    Button continue_button;

    int score;
    int counter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_activity);

        // assign the different views
        answer_textview = (TextView) findViewById(R.id.answerState);
        details_textview = (TextView) findViewById(R.id.checkedDetails);
        img_imageview = (ImageView) findViewById(R.id.checkedImage);

        continue_button = (Button) findViewById(R.id.cont);

        //get the information from the previous activity
        Intent in = getIntent();
        score = (in.getIntExtra("score", 0));       // get the score
        counter = in.getIntExtra("counter", 0);     // get the counter, which keeps track on how many times the player has played

        // compare the user answer against the correct answer (defined by and retrieved from the Game object from our database)
        if (in.getIntExtra("user_answer", 0) == in.getIntExtra("real_answer", 0)) {
            answer_textview.setText("CORRECT"); // set the text
            ++score;    // increment the score, since the user is correct
        } else {
            answer_textview.setText(" OOPS! ");
        }

        // display the details of the particular product
        details_textview.setText(in.getStringExtra("details"));

        //print the image, using the file name which is stored in the database
        Resources res = getResources();
        String img_name = in.getStringExtra("img");
        int resID = res.getIdentifier(img_name , "drawable", getPackageName());
        img_imageview.setImageResource(resID);

        // if counter is 5, that means the game is done.
        if (counter == 5) {
            continue_button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent in = new Intent(getApplicationContext(), GameOverActivity.class); // start the Game Over activity

                    in.putExtra("score", score);       // pass the score, to be displayed by the Game Over activity
                    in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(in);
                }
            });
        } else {
            continue_button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent in = new Intent(getApplicationContext(), GameActivity.class);    // if the user hasn't played 5 times yet, start another Game Activity class
                    in.putExtra("counter", counter); // pass the counter
                    in.putExtra("score", score);    // pass the score
                    in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(in);
                }
            });
        }


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.check_activity, menu);
        return true;
    }

}
