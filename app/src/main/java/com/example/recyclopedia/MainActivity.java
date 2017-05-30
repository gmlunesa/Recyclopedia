package com.example.recyclopedia;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.provider.CalendarContract;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static RecyclopediaDBHelper dbHelper;

    public static ArrayList<Game> gameList = new ArrayList<Game>();
    public static ArrayList<Integer> doneItems = new ArrayList<Integer>();

    public static int expandOpened = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView img = (ImageView) findViewById(R.id.recyclopediaLogo);
        Button text_search = (Button) findViewById(R.id.button_search);
        Button text_enc = (Button) findViewById(R.id.button_encyclopedia);
        Button text_game = (Button) findViewById(R.id.button_game);
        Button text_calendar = (Button) findViewById(R.id.button_calendar);

        dbHelper = new RecyclopediaDBHelper(this, RecyclopediaContract.RecyclopediaEntry.DBNAME, 1);
        gameList = dbHelper.getAllQuestions();


        text_search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent gameIntent = new Intent(getApplicationContext(), SearchActivity.class);
                gameIntent.putExtra("counter", 0);  // set the counter to zero since this is our first time playing the game
                gameIntent.putExtra("score", 0);    // set the score to zero, too
                gameIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(gameIntent);
            }
        });


        text_enc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent encIntent = new Intent(getApplicationContext(), EncyclopediaActivity.class);
                startActivity(encIntent);
            }
        });
        text_game.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent gameIntent = new Intent(getApplicationContext(), GameActivity.class);
                gameIntent.putExtra("counter", 0);  // set the counter to zero since this is our first time playing the game
                gameIntent.putExtra("score", 0);    // set the score to zero, too
                gameIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(gameIntent);
            }
        });

        text_calendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "Garbage Truck Schedule");
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Waste collection");
                intent.putExtra(CalendarContract.Events.STATUS, 1);
                intent.putExtra(CalendarContract.Events.HAS_ALARM, 1);
                startActivity(intent);
            }
        });



    }

    public static ArrayList<Game> getGameList () {
        return gameList; // retrieve the list of games here in the database
        // I did this to prevent recursive calls to the database, as Android Studio called me out on that one.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_help:
                Intent intent_help = new Intent(this, HelpActivity.class);
                this.startActivity(intent_help);
                break;
            case R.id.action_info:
                Intent intent_info = new Intent(this, InfoActivity.class);
                this.startActivity(intent_info);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

}
