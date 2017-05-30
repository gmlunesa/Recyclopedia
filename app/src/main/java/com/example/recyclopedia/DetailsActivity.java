package com.example.recyclopedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alpha on 12/10/2016.
 */
public class DetailsActivity extends AppCompatActivity {

    int groupPos;
    int childPos;
    String detail;
    TextView det;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        groupPos = intent.getIntExtra("listPos",0);
        childPos = intent.getIntExtra("childPos", 0);

       // det = (TextView)findViewById(R.id.textView);
        //det.setText(detail);



        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_details));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        String title = "Recyclopedia";

        String topic = intent.getStringExtra("title");

        System.out.println("topic = " + topic);
        detail = intent.getStringExtra("notes");
        TextView placeDetail = (TextView) findViewById(R.id.place_detail);
       TextView TopicName = (TextView) findViewById(R.id.title);
        ImageView placePicture = (ImageView) findViewById(R.id.image);

        collapsingToolbar.setTitle(title);
        placeDetail.setText(detail);
        TopicName.setText(topic);

        placePicture.setImageResource(R.drawable.tree);
    }

}
