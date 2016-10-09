package com.example.computer.hackny;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Computer on 10/9/2016.
 */
public class SQLHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLHelper";

    private static final String DATABASE_NAME = "iScavenger11";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_PEOPLE = "People";
    private static final String TABLE_TEAMS = "Teams";
    private static final String TABLE_SCAVENGER_ENTRIES = "Scavenger_Entries";
    private static final String TABLE_SCAVENGER_HUNTS = "Scavenger_Hunts";

    private static final String PEOPLE_COL_ID = "ID";
    private static final String PEOPLE_COL_USERNAME = "Username";
    private static final String PEOPLE_COL_HASH_PASS = "Hashed_Password";
    private static final String PEOPLE_COL_IMG_FILENAME = "Img_Filename";
    private static final String PEOPLE_COL_FUNFACT = "Funfact";

    private static final String TEAMS_COL_ID = "ID";
    private static final String TEAMS_COL_NAME = "Name";
    private static final String TEAMS_COL_MEMBER_USERNAME = "Member_Username";
    private static final String TEAMS_COL_IS_ADMIN = "Member_Is_Admin";
    private static final String TEAMS_COL_INVITE_CODE = "Invite_Code";
    private static final String TEAMS_COL_TIME_REMAINING = "Time_Remaining";

    private static final String SCAV_ENTRY_COL_ID = "ID";
    private static final String SCAV_ENTRY_COL_PROMPT = "Prompt";
    private static final String SCAV_ENTRY_COL_ANS_IMG_FILENAME = "Answer_Img_Filename";

    private static final String SCAV_HUNTS_COL_ID = "ID";
    private static final String SCAV_HUNTS_COL_NAME = "Name";
    private static final String SCAV_HUNTS_COL_INVITE_CODE = "Invite_Code";
    private static final String SCAV_HUNTS_COL_SUBMITTED_SCAV_ENTRY_ID = "Entry_ID";
    private static final String SCAV_HUNTS_COL_SUBMITTED_SCAV_ENTRY_TEAM_NAME = "Team_Name";
    private static final String SCAV_HUNTS_COL_SUBMITTED_IMG_FILENAME = "Submitted_Image_Filename";
    private static final String SCAV_HUNTS_COL_PROB_CORRECT = "Probability_Correct";
    private static final String SCAV_HUNTS_COL_TIME_REMAINING = "Time_Remaining";

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Utils_debug_awaheed.log_awaheed(TAG, "start of onCreate");

        String create_people_table = "CREATE TABLE " + TABLE_PEOPLE + "("
                + PEOPLE_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PEOPLE_COL_USERNAME + " TEXT,"
                + PEOPLE_COL_HASH_PASS + " TEXT,"
                + PEOPLE_COL_IMG_FILENAME + " TEXT,"
                + PEOPLE_COL_FUNFACT + " TEXT" + ")";
        String create_teams_table = "CREATE TABLE " + TABLE_TEAMS + "("
                + TEAMS_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TEAMS_COL_NAME + " TEXT,"
                + TEAMS_COL_MEMBER_USERNAME + " TEXT,"
                + TEAMS_COL_IS_ADMIN + " INTEGER,"
                + TEAMS_COL_INVITE_CODE + " TEXT,"
                + TEAMS_COL_TIME_REMAINING + " TEXT" + ")";
        String create_scav_entries_table = "CREATE TABLE " + TABLE_SCAVENGER_ENTRIES + "("
                + SCAV_ENTRY_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SCAV_ENTRY_COL_PROMPT + " TEXT,"
                + SCAV_ENTRY_COL_ANS_IMG_FILENAME + " TEXT" + ")";
        String create_scav_hunts_table = "CREATE TABLE " + TABLE_SCAVENGER_HUNTS + "("
                + SCAV_HUNTS_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SCAV_HUNTS_COL_NAME + " TEXT,"
                + SCAV_HUNTS_COL_INVITE_CODE + " TEXT,"
                + SCAV_HUNTS_COL_SUBMITTED_SCAV_ENTRY_ID + " INTEGER,"
                + SCAV_HUNTS_COL_SUBMITTED_SCAV_ENTRY_TEAM_NAME + " TEXT,"
                + SCAV_HUNTS_COL_SUBMITTED_IMG_FILENAME + " TEXT,"
                + SCAV_HUNTS_COL_PROB_CORRECT + " TEXT,"
                + SCAV_HUNTS_COL_TIME_REMAINING + " TEXT" + ")";

        Utils_debug_awaheed.log_awaheed(TAG, create_people_table);
        Utils_debug_awaheed.log_awaheed(TAG, create_teams_table);
        Utils_debug_awaheed.log_awaheed(TAG, create_scav_entries_table);
        Utils_debug_awaheed.log_awaheed(TAG, create_scav_hunts_table);

        db.execSQL(create_people_table); Utils_debug_awaheed.log_awaheed(TAG, "after people table");
        db.execSQL(create_teams_table); Utils_debug_awaheed.log_awaheed(TAG, "after teams table");
        db.execSQL(create_scav_entries_table); Utils_debug_awaheed.log_awaheed(TAG, "after entries table");
        db.execSQL(create_scav_hunts_table); Utils_debug_awaheed.log_awaheed(TAG, "after hunts table");

        Utils_debug_awaheed.log_awaheed(TAG, "end of onCreate");
    }


    void add_dummy_data(){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PEOPLE_COL_USERNAME, "awaheed9019");
        values.put(PEOPLE_COL_HASH_PASS, "62884565aa45aa");
        values.put(PEOPLE_COL_IMG_FILENAME, "anam.jpg");
        values.put(PEOPLE_COL_FUNFACT, "Chocolate!!");

        db.insert(TABLE_PEOPLE, null, values);

        values = new ContentValues();
        values.put(PEOPLE_COL_USERNAME, "danny777");
        values.put(PEOPLE_COL_HASH_PASS, "12884625aa45ab");
        values.put(PEOPLE_COL_IMG_FILENAME, "dan.jpg");
        values.put(PEOPLE_COL_FUNFACT, "Hi :)");

        db.insert(TABLE_PEOPLE, null, values);

        values = new ContentValues();
        values.put(PEOPLE_COL_USERNAME, "doraTheExplorer");
        values.put(PEOPLE_COL_HASH_PASS, "42884622aa45ab");
        values.put(PEOPLE_COL_IMG_FILENAME, "dora.jpg");
        values.put(PEOPLE_COL_FUNFACT, "Swiper No Swiping!");

        db.insert(TABLE_PEOPLE, null, values);





        values = new ContentValues();
        values.put(TEAMS_COL_NAME, "The A Team");
        values.put(TEAMS_COL_MEMBER_USERNAME, "awaheed9019");
        values.put(TEAMS_COL_IS_ADMIN, 1);
        values.put(TEAMS_COL_TIME_REMAINING, "00:22:00");

        db.insert(TABLE_TEAMS, null, values);

        values = new ContentValues();
        values.put(TEAMS_COL_NAME, "The A Team");
        values.put(TEAMS_COL_MEMBER_USERNAME, "abel");
        values.put(TEAMS_COL_IS_ADMIN, 1);
        values.put(TEAMS_COL_TIME_REMAINING, "00:22:00");

        db.insert(TABLE_TEAMS, null, values);

        values = new ContentValues();
        values.put(TEAMS_COL_NAME, "The A Team");
        values.put(TEAMS_COL_MEMBER_USERNAME, "gonzalez");
        values.put(TEAMS_COL_IS_ADMIN, 0);
        values.put(TEAMS_COL_TIME_REMAINING, "00:22:00");

        db.insert(TABLE_TEAMS, null, values);

        values = new ContentValues();
        values.put(TEAMS_COL_NAME, "The B Team");
        values.put(TEAMS_COL_MEMBER_USERNAME, "ryuk");
        values.put(TEAMS_COL_IS_ADMIN, 1);
        values.put(TEAMS_COL_TIME_REMAINING, "01:25:40");

        db.insert(TABLE_TEAMS, null, values);




        db.close();

    }



    /*
        This function was imported from the github repoitory at https://github.com/sanathp/DatabaseManager_For_Android
        and serves to debug the database, and nothing more.
     */
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"mesage"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEOPLE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEAMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCAVENGER_ENTRIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCAVENGER_HUNTS);
        onCreate(db);
    }
}
