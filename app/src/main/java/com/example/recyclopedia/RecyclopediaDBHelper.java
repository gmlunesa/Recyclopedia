package com.example.recyclopedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.recyclopedia.RecyclopediaContract.RecyclopediaEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mariz on 12/6/2016.
 */
public class RecyclopediaDBHelper extends SQLiteOpenHelper{

    // Database Version
    private static final int DATABASE_VERSION = 1;

    //Initialize DBHelper
    public RecyclopediaDBHelper(Context context, String DATABASE_NAME, int DATABASE_VERSION) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); // incremented database version from 2 to 3
    }

    public RecyclopediaDBHelper(Context context) {
        super(context, RecyclopediaEntry.DBNAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // SQL Statements --  this is for the topics about segregation
        String CREATE_TOPIC_TABLE = "CREATE TABLE " + RecyclopediaEntry.TOPIC_TABLE + "(" + RecyclopediaEntry.TOPIC_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + RecyclopediaEntry.TOPIC_COLUMN_TITLE + " TEXT," +
                RecyclopediaEntry.TOPIC_COLUMN_DETAILS + " TEXT," + RecyclopediaEntry.TOPIC_COLUMN_SUBJECT + " TEXT)";

        // this is an unused table, this was supposed to be for the search feature
        String CREATE_PRODUCT_TABLE = "CREATE TABLE " + RecyclopediaEntry.PRODUCT_TABLE + "(" + RecyclopediaEntry.PRODUCT_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + RecyclopediaEntry.PRODUCT_COLUMN_NAME + " TEXT," +
                RecyclopediaEntry.PRODUCT_COLUMN_TYPE + " TEXT," + RecyclopediaEntry.PRODUCT_COLUMN_SUGGESTIONS + " TEXT)";

        // the table for the game
        String CREATE_GAME_TABLE = "CREATE TABLE " + RecyclopediaEntry.GAME_TABLE + "(" + RecyclopediaEntry.GAME_COLUMN_ID +
                " INTEGER PRIMARY KEY," + RecyclopediaEntry.GAME_COLUMN_ITEM + " TEXT," +
                RecyclopediaEntry.GAME_COLUMN_ITEMTYPE + " INTEGER,"+ RecyclopediaEntry.GAME_COLUMN_DETAILS + " TEXT," + RecyclopediaEntry.GAME_COLUMN_IMAGE + " TEXT)";

        //Execute the sql statements and create the database
        db.execSQL(CREATE_TOPIC_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);
        db.execSQL(CREATE_GAME_TABLE);

        // Populate the game table.

        ContentValues values = new ContentValues();

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 1);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Plastic bottle");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Plastic bottles are recyclable. They can be used as alternate pots for plants, jars for our homes, or even ith decorative purposes.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "a");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Styropor");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Styropor, mostly used for food packaging, is non-biodegradable. We must refrain from using them, since it can clog up waterways, or worse, end up in the sea, where marine life might mistake them as food.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "b");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Fruit and vegetable peelings");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 1);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Fruit and vegetable peelings are biodegradable. They are great for compost pits, which you can easily make in your backyard. The soil in compost pits is generally healthier.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "c");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 4);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Glass bottles");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Glass bottles are recyclable. Various junkyards even buy them.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "d");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 5);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Old TV");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Old TV can be called as 'e-waste'. They must be taken to a nearby waste treatment plants.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "e");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);


        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 6);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Left-over food");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 1);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Left over food is biodegradable.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "f");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 7);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Shampoo bottles");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Shampoo bottles maybe huge and bulky, but they can be used again with a refill.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "g");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 8);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Dead leaves on the backyard");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 1);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Fallen leaves are biodegredable. Very good for compost pits.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "h");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 9);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Batteries");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Batteries are non biodegradable, and at the same time very dangerous. You must go to a nearby waste treatment facility.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "i");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 10);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Disposable Diapers");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Disposable diapers are non-biodegradable. Make sure to dispose of it at the proper trash bins since it can clog toilets.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "j");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 11);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Drinking straw");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Although it is small and thin, these drinking straws make their way to the ocean where marine creatures are endangered because of them.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "k");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 12);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Package box");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Package boxes are recyclable. It can serve as a storage space, and they come in different sizes, you'll have one for your needs.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "l");

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 13);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Human Remains");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 1);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "The human bod decomposes over time. Some wax them to preserve them.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "marcos");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 14);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Sanitary Napkin");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "You should always be careful not to flush them in the toilet. They clog them.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "napkin");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        //db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + RecyclopediaEntry.TOPIC_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RecyclopediaEntry.PRODUCT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RecyclopediaEntry.GAME_TABLE);

        // Creating tables again
        onCreate(db);
        db.close();
    }



    // this method returns all the questions stored in the database
    public ArrayList<Game> getAllQuestions () {

        ArrayList<Game> gameList = new ArrayList<Game>();

        String selectQuery = "SELECT * FROM " + RecyclopediaEntry.GAME_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        // parse the returned data from the database
        if (cursor.moveToFirst()) {

            do {

                // make a new game object
                Game item = new Game();

                // store the details from the DB to the object
                item.setGameID(Integer.parseInt(cursor.getString(0)));
                item.setGameItem(cursor.getString(1));
                item.setGameItemType(Integer.parseInt(cursor.getString(2)));
                item.setGameDetails(cursor.getString(3));
                item.setGameImage(cursor.getString(4));

                // add the object to the arraylist that will be returned by this function
                gameList.add(item);

                // Adding contact to list

            } while (cursor.moveToNext());

        }
        return gameList;
    }

    // this method adds a row in the topic table
    public void addTopic(String title, String details, String subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RecyclopediaEntry.TOPIC_COLUMN_TITLE, title);
        values.put(RecyclopediaEntry.TOPIC_COLUMN_DETAILS, details);
        values.put(RecyclopediaEntry.TOPIC_COLUMN_SUBJECT, subject);
        db.insert(RecyclopediaEntry.TOPIC_TABLE, null,values);
        db.close();
    }

    // this is a method to retrieve all the subjects, and return an arrayList
    public ArrayList<String> getListSubjects() {

        ArrayList<String> subjects = new ArrayList<String>();

        // the query to the database
        String selectQuery = "SELECT DISTINCT " + RecyclopediaEntry.TOPIC_COLUMN_SUBJECT+ " FROM " + RecyclopediaEntry.TOPIC_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {

            do {
                // add data to the arraylist that will be returned by this function
                subjects.add(cursor.getString(0));

            } while (cursor.moveToNext());

        }

        // return contact list
        db.close();
        return subjects;

    }

    // this will return the details based on a particular topic selected by the user, through String selected
    public String getDetails(String selected) {
        SQLiteDatabase db = this.getReadableDatabase();

        // the query
        String selectQuery = "SELECT " +  RecyclopediaEntry.TOPIC_COLUMN_DETAILS + " FROM " + RecyclopediaEntry.TOPIC_TABLE + " WHERE " + RecyclopediaEntry.TOPIC_COLUMN_TITLE +" = " + "'" + selected + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        String retDetail = "";

        // get the resulting data and return it
        if (cursor.moveToFirst()) {
            retDetail = cursor.getString(0);
        }

        return retDetail;
    }

    // this method retrieves all the topic items in the database, make a hashmap out of the data, and returns the hashmap
    public HashMap<String,List<String>> getHashMapTopics() {

        ArrayList<String> topics = getListSubjects(); // we get the list of the subjects/topics

        ArrayList<String> childList;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        HashMap<String, List<String>> hashMapTopics = new HashMap<>();
        String selectQuery;

        System.out.println(topics.size());
        System.out.println(topics.toString());
        int ctr = 0;

        // this loop will retrieve all the topic items, and store them in a hashmap which is arranged and categorized based on its topic
        for (String subj : topics) {
            childList = new ArrayList<String>();
            // the select query, we will select all the articles under a particular topic
            selectQuery = "SELECT * FROM " + RecyclopediaEntry.TOPIC_TABLE + " WHERE " + RecyclopediaEntry.TOPIC_COLUMN_SUBJECT + " = " + "'" + subj + "'";
            cursor = db.rawQuery(selectQuery, null);
            ctr = 0;
            // parse the returned data, and add them to an Array List
            if (cursor.moveToFirst()) {
                do {
                    System.out.println(ctr++);
                    childList.add(cursor.getString(1));
                } while (cursor.moveToNext());
            }
            // store the list in the HashMap, as well as the topic/subject
            hashMapTopics.put(subj, childList);
        }

        // return contact list
        db.close();
        return hashMapTopics;
    }
}
