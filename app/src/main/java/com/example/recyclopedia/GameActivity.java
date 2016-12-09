package com.example.recyclopedia;

import android.app.Activity;
import android.os.Bundle;
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

    //ImageView img_imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);




}
