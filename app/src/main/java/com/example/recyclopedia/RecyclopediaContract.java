package com.example.recyclopedia;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Mariz on 12/6/2016.
 */
public class RecyclopediaContract {
    // This is an empty constructor
    private RecyclopediaContract() {}

    //symbolic name of the entire provider
    public static final String CONTENT_AUTHORITY = "com.example.recyclopedia";

    //the path for the URI
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    //name of our database
    public static final String PATH_RECYCLOPEDIA = "recyclopediaDB";

    public static final class RecyclopediaEntry implements BaseColumns {

        //append to the content uri path the name of the database
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_RECYCLOPEDIA);

        //define the path of the database as well as the item type
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/" + CONTENT_URI + "/" + PATH_RECYCLOPEDIA;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_URI + "/" + PATH_RECYCLOPEDIA;

        public static final String DBNAME = "recyclopediaDB";

        /** The following are declarations for the tables and the columns **/

        // First table called topic -- this is for the encyclopedia
        public static final String TOPIC_TABLE = "topic";

        // Columns of the table "topic"
        public static final String TOPIC_COLUMN_ID = "topic_id"; // this is auto-increment
        public static final String TOPIC_COLUMN_TITLE = "topic_title"; // title of the topic
        public static final String TOPIC_COLUMN_DETAILS = "topic_details";  // details of such topic
        public static final String TOPIC_COLUMN_SUBJECT = "topic_subject"; // for more organized format, each topic is categorized

        /***/

        //Second table called product -- this is for the search feature (you search a product)
        public static final String PRODUCT_TABLE = "product";

        //Columns of the table product
        public static final String PRODUCT_COLUMN_ID = "product_id"; // this is auto-increment
        public static final String PRODUCT_COLUMN_NAME = "product_name"; // this is the name of the product (which the user searches)
        public static final String PRODUCT_COLUMN_TYPE = "product_type"; // biodegradable / non-biodegradable / recyclable
        public static final String PRODUCT_COLUMN_SUGGESTIONS = "product_suggestions"; // if recyclable, then there are suggestions

        /***/

        //Third table called game -- this is for the mini-game
        public static final String GAME_TABLE = "game";

        //Columns of the table game
        public static final String GAME_COLUMN_ID = "game_id";  // this is auto increment
        public static final String GAME_COLUMN_ITEM = "game_item"; // this is the item the game will show
        public static final String GAME_COLUMN_ITEMTYPE = "game_itemtype"; // the type of the game item
        public static final String GAME_COLUMN_DETAILS = "game_details"; // corresponding image for the item
        public static final String GAME_COLUMN_IMAGE = "game_image"; // corresponding image for the item

        /***/

    }


}
