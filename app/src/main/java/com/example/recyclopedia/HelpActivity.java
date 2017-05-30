package com.example.recyclopedia;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mariz on 2/19/2017.
 */
public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        String title = "Help";
        String detail = "A very simple Android application that encourages people to reduce, reuse and recycle. The following are the features:\n" +
                "• Search the database for details about different kinds of trash\n" +
                "• Read about different topics about recycling in our built-in encylopedia\n" +
                "• Play an exciting trivia game while learning at the same time" +
                "• Schedule garbage collection through the calendar";
        String contact = "We can be contacted through our emails:\n" +
                "• cggulane@up.edu.ph\n" +
                "• gmlunesa@up.edu.ph\n" +
                "• arpacada@up.edu.ph\n";

        TextView placeDetail = (TextView) findViewById(R.id.place_detail);
        TextView placeContact =  (TextView) findViewById(R.id.place_contact);
        ImageView placePicture = (ImageView) findViewById(R.id.image);

        collapsingToolbar.setTitle(title);
        placeDetail.setText(detail);
        placeContact.setText(contact);

        placePicture.setImageResource(R.drawable.help);

    }

}
