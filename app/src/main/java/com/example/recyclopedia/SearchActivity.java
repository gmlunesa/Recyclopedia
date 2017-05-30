package com.example.recyclopedia;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import android.app.SearchManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] animalNameList;
    ArrayList<Game> arraylist = new ArrayList<Game>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_search));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       /* SearchView simpleSearchView = (SearchView) findViewById(R.id.simpleSearchView); // inititate a search view
        CharSequence query = simpleSearchView.getQuery();

        CharSequence queryHint = simpleSearchView.getQueryHint();
        simpleSearchView.setIconifiedByDefault(false);*/

        list = (ListView) findViewById(R.id.listview);

        arraylist = MainActivity.getGameList();

        adapter = new ListViewAdapter(this, arraylist);


        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}
