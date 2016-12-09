package com.example.recyclopedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.recyclopedia.RecyclopediaContract.RecyclopediaEntry;

import java.util.ArrayList;

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

        // SQL Statements
        String CREATE_TOPIC_TABLE = "CREATE TABLE " + RecyclopediaEntry.TOPIC_TABLE + "(" + RecyclopediaEntry.TOPIC_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + RecyclopediaEntry.TOPIC_COLUMN_TITLE + " TEXT," +
                RecyclopediaEntry.TOPIC_COLUMN_DETAILS + " TEXT," + RecyclopediaEntry.TOPIC_COLUMN_SUBJECT + " TEXT)";

        String CREATE_PRODUCT_TABLE = "CREATE TABLE " + RecyclopediaEntry.PRODUCT_TABLE + "(" + RecyclopediaEntry.PRODUCT_COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + RecyclopediaEntry.PRODUCT_COLUMN_NAME + " TEXT," +
                RecyclopediaEntry.PRODUCT_COLUMN_TYPE + " TEXT," + RecyclopediaEntry.PRODUCT_COLUMN_SUGGESTIONS + " TEXT)";

        String CREATE_GAME_TABLE = "CREATE TABLE " + RecyclopediaEntry.GAME_TABLE + "(" + RecyclopediaEntry.GAME_COLUMN_ID +
                " INTEGER PRIMARY KEY," + RecyclopediaEntry.GAME_COLUMN_ITEM + " TEXT," +
                RecyclopediaEntry.GAME_COLUMN_ITEMTYPE + " INTEGER,"+ RecyclopediaEntry.GAME_COLUMN_DETAILS + " TEXT," + RecyclopediaEntry.GAME_COLUMN_IMAGE + " TEXT)";

        //Execute the sql statements and create the database
        db.execSQL(CREATE_TOPIC_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);
        db.execSQL(CREATE_GAME_TABLE);

        //initGameTable(); // Populate the table.

        ContentValues values = new ContentValues();

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 1);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Plastic bottle");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Plastic bottles are recyclable. They can be used as alternate pots for plants, jars for our homes, or even ith decorative purposes.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "sample");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Styropor");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Styropor, mostly used for food packaging, is non-biodegradable. We must refrain from using them, since it can clog up waterways, or worse, end up in the sea, where marine life might mistake them as food.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "ne");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Fruit and vegetable peelings");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 1);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Fruit and vegetable peelings are biodegradable. They are great for compost pits, which you can easily make in your backyard. The soil in compost pits is generally healthier.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "nw");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 4);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Glass bottles");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Glass bottles are recyclable. Various junkyards even buy them.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "nw");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 5);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Old TV");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Old TV can be called as 'e-waste'. They must be taken to a nearby waste treatment plants.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "nw");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);


        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 6);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Left-over food");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 1);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Left over food is biodegradable.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "nw");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 7);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Shampoo bottles");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Shampoo bottles maybe huge and bulky, but they can be used again with a refill.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "nw");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 8);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Dead leaves on the backyard");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 1);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Fallen leaves are biodegredable. Very good for compost pits.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "nw");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 9);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Batteries");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Batteries are non biodegradable, and at the same time very dangerous. You must go to a nearby waste treatment facility.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "nw");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 10);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Disposable Diapers");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Disposable diapers are non-biodegradable. Make sure to dispose of it at the proper trash bins since it can clog toilets.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "nw");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 11);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Drinking straw");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Although it is small and thin, these drinking straws make their way to the ocean where marine creatures are endangered because of them.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "nw");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 12);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Package box");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Package boxes are recyclable. It can serve as a storage space, and they come in different sizes, you'll have one for your needs.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "nw");
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


    // insert one question

    public void addQuestion (Game entry) {

        //retrieve the database
        SQLiteDatabase db = this.getWritableDatabase();

        //get content values
        ContentValues values = new ContentValues();

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, entry.getGameID());
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, entry.getGameItem());
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, entry.getGameItemType());
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, entry.getGameDetails());
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, entry.getGameImage());

        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

    }

    public ArrayList<Game> getAllQuestions () {

        ArrayList<Game> gameList = new ArrayList<Game>();

        String selectQuery = "SELECT * FROM " + RecyclopediaEntry.GAME_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {

                Game item = new Game();

                item.setGameID(Integer.parseInt(cursor.getString(0)));
                item.setGameItem(cursor.getString(1));
                item.setGameItemType(Integer.parseInt(cursor.getString(2)));
                item.setGameDetails(cursor.getString(3));
                item.setGameImage(cursor.getString(4));

                gameList.add(item);

                // Adding contact to list

            } while (cursor.moveToNext());

        }
        return gameList;
    }

}
