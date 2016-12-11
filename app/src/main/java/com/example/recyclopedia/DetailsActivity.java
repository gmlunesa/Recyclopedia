package com.example.recyclopedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Alpha on 12/10/2016.
 */
public class DetailsActivity extends Activity {

    int groupPos;
    int childPos;
    String detail;

    // initialize the TextView
    TextView det;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        Intent intent = getIntent();
        // gets the variables from the topic object selected, sent by the previous activity, and assign them to variables
        groupPos = intent.getIntExtra("listPos",0);
        childPos = intent.getIntExtra("childPos", 0);
        detail = intent.getStringExtra("notes");
        det = (TextView)findViewById(R.id.textView);
        det.setText(detail);    // prints the topic details
    }

}
