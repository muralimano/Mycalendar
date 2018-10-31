package com.whatsapp.murali.mycalendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SunDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "TamilCalendar47";

    public static final String TABLE_NAME = "Sun_Info_table";

    public static final String COL_1 = "ENGLISH_DATE";

    public static final String COL_2 = "TAMIL_DATE";

    public static final String COL_3 = "STAR_NAME";

    public static final String COL_4 = "CURRENT_LOCATION";

    public SunDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.i("Notifications", "DataBaseHelper onCreate start ");

            //   String sql="create table " + TABLE_NAME + "(ENGLISH_DATE TEXT PRIMARY KEY, TAMIL_DATE TEXT,STAR_NAME TEXT ,TAMIL_TIME_NALIKAI TEXT,TAMIL_TIME_VINADI TEXT)";
            String sql = "create table" + TABLE_NAME + "(ENGLISH_DATE TEXT PRIMARY KEY, TAMIL_DATE TEXT, STAR_NAME TEXT, CURRENT_LOCATION TEXT)";

            Log.i("Notifications", "DataBaseHelper sql " + sql);

            db.execSQL(sql);
            Log.i("Notifications", "DataBaseHelper onCreate end version" + db.getVersion());

            Cursor cur = db.rawQuery("select * from " + TABLE_NAME, null);

            if (cur.getCount() == 0) {
                Log.i("Notifications", "Initail Value inserted to database");
                InsertIntoDb("16/04/2018", "16/04/2018", "1", "Chennai");
                InsertIntoDb("17/04/2018", "17/04/2018", "2", "Vellore");

            } else {
                Log.i("Notifications", "select data available Success");
            }


        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i("Notifications", "DataBaseHelper onUpgrade start ");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

        Log.i("Notifications", "DataBaseHelper onUpgrade end ");
    }

    public void InsertIntoDb(String ENGLISH_DATE, String TAMIL_DATE, String STAR_NAME, String CURRENT_LOCATION) {
        Log.i("Notification", "Insert Started");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ENGLISH_DATE, ENGLISH_DATE);
        contentValues.put(TAMIL_DATE, TAMIL_DATE);
        contentValues.put(STAR_NAME, STAR_NAME);
        contentValues.put(CURRENT_LOCATION, CURRENT_LOCATION);


        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {

            Log.i("Notifications", TABLE_NAME + "DataBaseHelper insertThiThiDB Fails ");
        } else {

            Log.i("Notifications", TABLE_NAME + "DataBaseHelper Success ");
        }


    }
}

