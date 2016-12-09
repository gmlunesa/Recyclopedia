package com.example.recyclopedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.recyclopedia.RecyclopediaContract.RecyclopediaEntry;

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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + RecyclopediaEntry.TOPIC_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RecyclopediaEntry.PRODUCT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RecyclopediaEntry.GAME_TABLE);

        // Creating tables again
        onCreate(db);
    }


    public void initGameTable() {
        Game g1 = new Game(1, "Plastic bottle", 2, "details here", "getdrawable.image");
        addQuestion(g1);
        Game g2 = new Game(2, "Plastic bottle", 2, "details here", "getdrawable.image");
        addQuestion(g2);

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


}
