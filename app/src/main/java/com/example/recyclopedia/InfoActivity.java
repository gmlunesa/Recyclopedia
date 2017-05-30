package com.example.recyclopedia;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mariz on 2/19/2017.
 */
public class InfoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        String title = "Info";
        String detail = "We, the Basurerawwr, think that it's time to help the Filipino people to educate themselves of the importance of proper waste disposal. There is a need for environmental awareness among the citizens so cooperation and responsibility may be achieved. It may be a small step, but every effort counts in helping our environment.\n" +
                "Our project is open sourced, and could be accessed and forked through our Github repository at http://github.com/gmlunesa/recyclopedia\n";
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
