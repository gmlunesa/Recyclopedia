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
        addTopic(db,"Examples of Biodegradable materials","Examples of Biodegradable materials, often referred to as “bio-waste”, include the following:\n" +
                "\n" +
                "• Human and animal waste\n" +
                "• Plant products, wood, paper, food waste, leaves, grass clippings\n" +
                "• Remains from the death of living creatures\n" +
                "\n" +
                "It is very important to note that biodegradable waste can serve to support the future life of other organisms. This waste can be used to provide nourishment and a healthy environment condition for living organisms, which of course includes humans.\n" +
                "http://sprecycling.com/biodegradable-and-non-biodegradable-materials/\n", "Biodegradable Wastes");
        addTopic(db, "Examples of Non-Biodegradable Wastes", "Materials having properties that do not breakdown or decay are called Non-biodegradable.\n" +
                "\n" +
                "Examples include:\n" +
                "• Glass\n" +
                "• Metals\n" +
                "• Plastics\n" +
                "• Electronic devices\n" +
                "• Medical waste\n" +
                "\n" +
                "Non-biodegradable materials do not breakdown naturally. But, that doesn’t mean they cannot be reused. The key difference here is that the process requires time, energy and expense. Glass and plastic can be reused to make other products, but the waste must first be separated by type of material and then processed into a usable substance.\n" +
                "http://sprecycling.com/biodegradable-and-non-biodegradable-materials/\n","Non Biodegradable Wastes");
        addTopic(db,"Landfill","The Landfill is the most popularly used method of waste disposal used today. This process of waste disposal focuses attention on burying the waste in the land. Landfills are found in all areas. There is a process used that eliminates the odors and dangers of waste before it is placed into the ground. While it is true this is the most popular form of waste disposal it is certainly far from the only" +
                " procedure and one that may also bring with it an assortment of space.","Methods of Waste Disposal" );
        addTopic(db, "Overview", "This law aims for the reduction of solid waste through source reduction and waste minimization measures, treatment and disposal of solid waste in accordance with ecologically sustainable development principles. (Sec. 2-C)\n" +
                "It also aims to ensure the proper segregation, collection, transport, storage, treatment and disposal of solid waste through the formulation and adoption of the best environmental practice in ecological waste management excluding incineration.\n" +
                "It considers “waste as a resource that can be recovered”, emphasizing on recycling, reuse and composting as methods to minimize waste problems.\n", "Ecological Solid Waste Management Act of 2000 (RA 9003)");
        addTopic(db, "Three r\'s", "• Reduce\n• Recover\n• Recycle\n","Ecological Solid Waste Management Act of 2000 (RA 9003)");
        addTopic(db,"Waste Characterization and Segregation ","The Act provided a special account in the National Treasury called the Solid" +
                " Waste Management Fund.  This will be sourced from fines and penalties imposed, " +
                "proceeds of permits and licenses, donations, endowments, grants and contributions" +
                " and amount allocated under the annual General Appropriations Act. The Fund will be utilized " +
                "to finance products, facilities, technologies, and processes that would enhance proper solid waste" +
                " management; awards and incentives; research programs; information, education, communication and monitoring " +
                "activities; technical assistance; and capability building activities.", "Ecological Solid Waste Management Act of 2000 (RA 9003)" );
        addTopic(db,"Types of Waste According to Source", "•\tResidual – waste with no commercial value meant for disposal\n" +
                "•\tRecyclable - waste that can be reused\n" +
                "•\t Biodegradable – waste that can be decomposed by organisms\n" +
                "•\tHazardous – waste that may cause or contribute to mortality or illness\n" +
                "•\t Toxic – waste that may cause immediate death or body damage.\n", "Ecological Solid Waste Management Act of 2000 (RA 9003)");
        addTopic(db,"Provisions of RA 9003", "The said act gives strong emphasis on the role of municipal and local government units (LGUs) providing for the creation of Solid Waste Management Communities up to the barangay level. " +
                "This requires the participation of nongovernment offices, people’s organizations, church leaders, schools, businesses and community organizations.","Ecological Solid Waste Management Act of 2000 (RA 9003)");

        addTopic(db,"Penal Provisions","Chapter 6 provides a comprehensive list of prohibited acts including: (1) littering, throwing, dumping of waste matters in public places; (2) undertaking activities in violation of sanitation operation; (3) open burning of solid waste; (4) causing non-segregated waste; (5) squatting in open dumps and landfills; (6) open dumping, burying of biodegradable materials in flood-prone areas; (7) unauthorized removal of recyclable material; (8) mixing of source-separated recyclable material with other solid waste; (9) establishment or operation of open-dumps; (10) manufacturing, distributing, using, and importing consumer products that are non-environmentally-friendly materials; (11)  importing toxic wastes misrepresented as “recyclable” or “with recyclable content”; (12) transporting and dumping in bulk in areas other than facility centers; (13) site preparation, construction, expansion or operation of waste management facilities without an Environmental Compliance Certificate and not conforming with the land use plan of LGUs; (14) construction of establishment" +
                " within 200 meters from dump sites or sanitary landfills; and (15) operation of waste disposal facility on any aquifer," +
                " groundwater reservoir or watershed area.  ","Ecological Solid Waste Management Act of 2000 (RA 9003)" );
        addTopic(db,"Financing Solid Waste Management","The Act provided a special account in the National Treasury called the Solid Waste Management Fund.  This will be sourced from fines and penalties imposed, proceeds of permits and licenses, donations, endowments, grants and contributions and amount allocated under the annual General Appropriations Act. The Fund will be utilized to finance products, facilities, technologies, and processes that would enhance proper solid waste management; awards and incentives; research programs; " +
                "information, education, communication and monitoring activities; technical assistance; and capability building activities.","Ecological Solid Waste Management Act of 2000 (RA 9003)" );

        addTopic(db,"Incineration/Combustion ","Incineration or combustion is a type disposal method in which municipal solid wastes are burned at high temperatures so as as to convert them into residue and gaseous products. The biggest advantage of this type of method is that it can reduce the volume of solid waste to 20 to 30 percent of the original volume, decreases the space they take up and reduce the stress on landfills.","Methods of Waste Disposal" );
        addTopic(db,"Recovery and Recycling ","Resource recovery is the process of taking useful discarded items for a specific next use. These discarded items are then processed to extract or recover materials and resources or convert them to energy in the form of useable heat, electricity or fuel.","Methods of Waste Disposal" );
        addTopic(db,"Republic Act 7160 (Local Government Code)","• Effective 1991\n" +
                "• Mandates local government units to exercise powers, functions and responsibilities in providing basic services and facilities " +
                "related to general hygiene, sanitation, beautification and solid waste collection, transport and disposal.\n","Examples of Philippine Environmental Laws" );
        addTopic(db,"Presidential Decree 825", "• Effective November 7, 1975\n" +
                "• Penalizes improper disposal of garbage and other forms of being dirty. Violators may be imprisoned " +
                "for not less than five days or more than a year or pay a fine or not less that P100 or more than P2,000 or both.\n","Examples of Philippine Environmental Laws");
        addTopic(db,"Anti-Dumping Law", "• Effective September 5, 1938\n" +
                "• Prohibits the dumping into rivers of refuse waste matter or substance of any kind.\n" +
                "• Punishment of imprisonment of not more than six months or by a fine of not more than P200 or both.\n","Examples of Philippine Environmental Laws");
        addTopic(db,"Republic Act 6969", "• Effective 1990\n" +
                "• Mandates the control and management of the import, manufacture, processing, " +
                "distribution, use, transport, treatment and disposal of toxic substances and hazardous and nuclear wastes " +
                "in the country.\n","Examples of Philippine Environmental Laws" );

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
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Styropor, mostly used for food packaging, is non-biodegradable. They clog waterways and harm marine life.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "b");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Fruit and vegetable peelings");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 1);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Fruit and vegetable peelings are biodegradable. They are great for compost pits.");
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
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Human remains are biodegradable. The human body decomposes over time. Some wax them to preserve them.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "marcos");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 14);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Sanitary Napkin");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 2);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Sanitary napkins are non-biodegrable. You should always be careful not to flush them in the toilet. They clog them.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "napkin");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        values.put(RecyclopediaEntry.GAME_COLUMN_ID, 15);
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEM, "Toilet roll");
        values.put(RecyclopediaEntry.GAME_COLUMN_ITEMTYPE, 3);
        values.put(RecyclopediaEntry.GAME_COLUMN_DETAILS, "Toilet rolls are recyclable. They can be used for different kinds of cute crafts.");
        values.put(RecyclopediaEntry.GAME_COLUMN_IMAGE, "toilet");
        db.insert(RecyclopediaEntry.GAME_TABLE, null, values);

        /*values.put(RecyclopediaEntry.TOPIC_COLUMN_ID, 1);
        values.put(RecyclopediaEntry.TOPIC_COLUMN_TITLE, "Overview");
        values.put(RecyclopediaEntry.TOPIC_COLUMN_DETAILS, "This law aims for the reduction of solid waste through source reduction and waste minimization measures, treatment and disposal of solid waste in accordance with ecologically sustainable development principles. (Sec. 2-C)\n" +
                "It also aims to ensure the proper segregation, collection, transport, storage, treatment and disposal of solid waste through the formulation and adoption of the best environmental practice in ecological waste management excluding incineration.\n" +
                "It considers “waste as a resource that can be recovered”, emphasizing on recycling, reuse and composting as methods to minimize waste problems.\n");
        values.put(RecyclopediaEntry.TOPIC_COLUMN_SUBJECT, "Ecological Solid Waste Management Act of 2000 (RA 9003)\"");
        db.insert(RecyclopediaEntry.TOPIC_TABLE, null, values);


        values.put(RecyclopediaEntry.TOPIC_COLUMN_ID, 2);
        values.put(RecyclopediaEntry.TOPIC_COLUMN_TITLE, "Waste Characterization and Segregation");
        values.put(RecyclopediaEntry.TOPIC_COLUMN_DETAILS, "The Act provided a special account in the National Treasury called the Solid" +
                " Waste Management Fund.  This will be sourced from fines and penalties imposed, " +
                "proceeds of permits and licenses, donations, endowments, grants and contributions" +
                " and amount allocated under the annual General Appropriations Act. The Fund will be utilized " +
                "to finance products, facilities, technologies, and processes that would enhance proper solid waste" +
                " management; awards and incentives; research programs; information, education, communication and monitoring " +
                "activities; technical assistance; and capability building activities.");
        values.put(RecyclopediaEntry.TOPIC_COLUMN_SUBJECT, "Ecological Solid Waste Management Act of 2000 (RA 9003)");
        db.insert(RecyclopediaEntry.TOPIC_TABLE, null, values);*/

        /*values.put(RecyclopediaEntry.TOPIC_COLUMN_ID, 3);
        values.put(RecyclopediaEntry.TOPIC_COLUMN_TITLE, "");
        values.put(RecyclopediaEntry.TOPIC_COLUMN_DETAILS, "");
        values.put(RecyclopediaEntry.TOPIC_COLUMN_SUBJECT, "");
        db.insert(RecyclopediaEntry.TOPIC_TABLE, null, values);

        values.put(RecyclopediaEntry.TOPIC_COLUMN_ID, 4);
        values.put(RecyclopediaEntry.TOPIC_COLUMN_TITLE, "");
        values.put(RecyclopediaEntry.TOPIC_COLUMN_DETAILS, "");
        values.put(RecyclopediaEntry.TOPIC_COLUMN_SUBJECT, "");
        db.insert(RecyclopediaEntry.TOPIC_TABLE, null, values);

        values.put(RecyclopediaEntry.TOPIC_COLUMN_ID, 5);
        values.put(RecyclopediaEntry.TOPIC_COLUMN_TITLE, "");
        values.put(RecyclopediaEntry.TOPIC_COLUMN_DETAILS, "");
        values.put(RecyclopediaEntry.TOPIC_COLUMN_SUBJECT, "");
        db.insert(RecyclopediaEntry.TOPIC_TABLE, null, values);*/

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

    public void addTopic(SQLiteDatabase db, String title, String details, String subject) {
        ContentValues values = new ContentValues();
        values.put(RecyclopediaEntry.TOPIC_COLUMN_TITLE, title);
        values.put(RecyclopediaEntry.TOPIC_COLUMN_DETAILS, details);
        values.put(RecyclopediaEntry.TOPIC_COLUMN_SUBJECT, subject);
        db.insert(RecyclopediaEntry.TOPIC_TABLE, null, values);
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

    // this method returns all the questions stored in the database
    public ArrayList<Topic> getAllTopics () {
        ArrayList<Topic> topicList = new ArrayList<Topic>();
        String selectQuery = "SELECT * FROM " + RecyclopediaEntry.TOPIC_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // parse the returned data from the database
        if (cursor.moveToFirst()) {
            do {
                // make a new game object
                Topic item = new Topic();
                // store the details from the DB to the object
                item.setTopicID(Integer.parseInt(cursor.getString(0)));
                item.setTopicTitle(cursor.getString(1));
                item.setTopicDetails(cursor.getString(2));
                item.setTopicSubject(cursor.getString(3));

                // add the object to the arraylist that will be returned by this function
                topicList.add(item);
                // Adding contact to list
            } while (cursor.moveToNext());
        }
        return topicList;
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
