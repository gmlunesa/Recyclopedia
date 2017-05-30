package com.example.recyclopedia;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Cedezmarie on 12/9/2016.
 */

public class AddingSchedActivity extends AppCompatActivity {
    DatePicker datePicker;
    EditText description;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding_sched);

        description = (EditText) findViewById(R.id.descriptionText);
        final String desc = (description).getText().toString();
        //Calendar cal = Calendar.getInstance();
        //calls the calendar intent that adds an event
        //the title is pre-written
        Button setSched = (Button) findViewById(R.id.setschedbutt);

        setSched.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "Garbage Truck Schedule");
                intent.putExtra(CalendarContract.Events.DESCRIPTION, desc);
                intent.putExtra(CalendarContract.Events.STATUS, 1);
                intent.putExtra(CalendarContract.Events.HAS_ALARM, 1);
                startActivity(intent);
            }
        });


    }
}
