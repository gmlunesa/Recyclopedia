package com.example.recyclopedia;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
/**
 * Created by Alpha on 12/10/2016.
 */
public class GarbageCollection extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage_main);
        //go to schedule button
        Button schedButton = (Button) findViewById(R.id.scheduleButton);
        schedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //goes  to addingschedactivity
            public void onClick(View v) {
                Log.i("clicks", "You Clicked B1");
                Intent i = new Intent(getApplicationContext(), AddingSchedActivity.class);
                startActivity(i);
            }
        });
        Button backButton = (Button) findViewById(R.id.Backbutton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}


