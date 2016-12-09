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

    TextView answer_textview;
    TextView details_textview;
    ImageView img_imageview;

    Button continue_button;

    int score;
    int counter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_activity);

        answer_textview = (TextView) findViewById(R.id.answerState);
        details_textview = (TextView) findViewById(R.id.checkedDetails);
        img_imageview = (ImageView) findViewById(R.id.checkedImage);

        continue_button = (Button) findViewById(R.id.cont);

        Intent in = getIntent();
        score = (in.getIntExtra("score", 0));
        counter = in.getIntExtra("counter", 0);
        Log.d("user answer", ": " + in.getIntExtra("user_answer", 0));
        if (in.getIntExtra("user_answer", 0) == in.getIntExtra("real_answer", 0)) {
            answer_textview.setText("CORRECT");
            ++score;
        } else {
            answer_textview.setText(" WRONG ");
        }

        details_textview.setText(in.getStringExtra("details"));

        Resources res = getResources();
        String img_name = in.getStringExtra("img");
        int resID = res.getIdentifier(img_name , "drawable", getPackageName());
        img_imageview.setImageResource(resID);
        //img_imageview


        continue_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), GameActivity.class);
                in.putExtra("counter", counter);
                in.putExtra("score", score);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.check_activity, menu);
        return true;
    }

}
