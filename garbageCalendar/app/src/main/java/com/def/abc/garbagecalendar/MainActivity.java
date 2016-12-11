package com.def.abc.garbagecalendar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //go to schedule button
        Button schedButton = (Button) findViewById(R.id.scheduleButton);
        schedButton.setOnClickListener(this);
    }

        @Override
        //goes  to addingschedactivity
        public void onClick(View v) {
            Log.i("clicks","You Clicked B1");
            Intent i=new Intent(MainActivity.this, AddingSchedActivity.class);
            startActivity(i);
        }
    }
