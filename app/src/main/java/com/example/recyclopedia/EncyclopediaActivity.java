package com.example.recyclopedia;

/**
 * Created by Alpha on 2/21/2017.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class EncyclopediaActivity extends AppCompatActivity {




        ExpandableListView explistView;
        HashMap<String,List<String>> listHashMap = new HashMap<String, List<String>>();
        EncyclopediaAdapter explistAdapter;
        RecyclopediaDBHelper dbHelper;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.exp_main);


            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_encyclopedia));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //Button backButton = (Button) findViewById(R.id.Backbutt);
//            backButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(i);
//                }
//            });

            dbHelper = new RecyclopediaDBHelper(this);
            //populateData();
            // dbHelper.populateTopic();
            explistView = (ExpandableListView) findViewById(R.id.exp_list);
            //System.out.print("yeah " + dbHelper.getAllTopics());
            explistAdapter = new EncyclopediaAdapter(this, dbHelper.getHashMapTopics(), dbHelper.getListSubjects());

            explistView.setAdapter(explistAdapter);

            explistView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    final String selected = (String) explistAdapter.getChild(
                            groupPosition, childPosition);
                    final String topic = (String) explistAdapter.getGroup(groupPosition);

                    Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                            .show();
                    Intent in = new Intent(getApplicationContext(),DetailsActivity.class);
                    in.putExtra("listPos", groupPosition);
                    in.putExtra("childPos", childPosition);
                    in.putExtra("notes", dbHelper.getDetails(selected));
                    in.putExtra("title", topic);
                    startActivity(in);

                    return true;
                }
            });


        }
    }



