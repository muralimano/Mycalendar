package com.whatsapp.murali.mycalendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;

public class StarsDataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TamilCalendar47.db";

    public static final String TABLE_NAME="Star_Info_table";

    public static final String COL_1="ENGLISH_DATE";

    public static final String COL_2="TAMIL_DATE";

    public static final String COL_3="STAR_NAME";

    public static final String COL_4="TAMIL_TIME_NALIKAI";

    public static final String COL_5="TAMIL_TIME_VINADI";

    public static final String COL_6="ENGLISH_TIME_HOUR";

    public static final String COL_7="ENGLISH_TIME_MINUTES";

    public StarsDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.i("Notifications", "DataBaseHelper onCreate start ");

            //   String sql="create table " + TABLE_NAME + "(ENGLISH_DATE TEXT PRIMARY KEY, TAMIL_DATE TEXT,STAR_NAME TEXT ,TAMIL_TIME_NALIKAI TEXT,TAMIL_TIME_VINADI TEXT)";
            String sql = "create table " + TABLE_NAME + " (ENGLISH_DATE TEXT PRIMARY KEY, TAMIL_DATE TEXT, STAR_NAME TEXT, TAMIL_TIME_NALIKAI TEXT, TAMIL_TIME_VINADI TEXT, ENGLISH_TIME_HOUR TEXT, ENGLISH_TIME_MINUTES TEXT)";

            Log.i("Notifications", "DataBaseHelper sql " + sql);

            db.execSQL(sql);
            Log.i("Notifications", "DataBaseHelper onCreate end version" + db.getVersion());

            Cursor cur = db.rawQuery("select * from " + TABLE_NAME, null);

//            if (cur.getCount() == 0) {
//                insertIntoDB("17/10/2018","1/10/2018","swathi+","27","44","5","18P");
//                insertIntoDB("18/10/2018","2/10/2018","avittam","32","56","7","25P");
//                insertIntoDB("19/10/2018","3/10/2018","sathayam+","39","17","9","57P");
//                insertIntoDB("20/10/2018","4/10/2018","puratathi","46","21","12","48A");
//                insertIntoDB("21/10/2018","5/10/2018","uthirattathi+*","51","58","3","51A");
//                insertIntoDB("22/10/2018","6/10/2018","revathi+*","60","00","...","...");
//                insertIntoDB("23/10/2018","7/10/2018","revathi+*","1","45","7","00A");
//                insertIntoDB("24/10/2018","8/10/2018","swathi+","9","25","10","03A");
//                insertIntoDB("25/10/2018","9/10/2018","swathi+","16","19","12","49P");
//                insertIntoDB("26/10/2018","10/10/2018","swathi+","21","56","3","04P");
//                insertIntoDB("27/10/2018","11/10/2018","swathi+","25","27","4","47P");
//                insertIntoDB("28/10/2018","12/10/2018","swathi+","27","36","5","21P");
//                insertIntoDB("29/10/2018","13/10/2018","swathi+","27","12","5","12P");
//                insertIntoDB("30/10/2018","14/10/2018","swathi+","24","42","4","13P");
//                insertIntoDB("1/10/2018","15/10/2018","swathi+","20","19","2","28P");
//                insertIntoDB("2/10/2018","16/10/2018","swathi+","14","26","17","07P");
//                insertIntoDB("3/10/2018","17/10/2018","swathi+","7","33","9","04A");
//                insertIntoDB("3/10/2018","17/10/2018","swathi+","59","59","5","21A");
//                insertIntoDB("4/10/2018","18/10/2018","swathi+","52","25","3","20A");
//                insertIntoDB("5/10/2018","19/10/2018","swathi+","45","14","12","28A");
//                insertIntoDB("6/10/2018","20/10/2018","swathi+","38","54","9","57P");
//                insertIntoDB("7/10/2018","21/10/2018","swathi+","33","46","7","54P");
//                insertIntoDB("8/10/2018","22/10/2018","swathi+","30","08","6","28P");
//                insertIntoDB("9/10/2018","23/10/2018","swathi+","28","10","5","41P");
//                insertIntoDB("10/10/2018","24/10/2018","swathi+","27","55","5","35P");
//                insertIntoDB("11/10/2018","25/10/2018","swathi+","29","17","6","09P");
//                insertIntoDB("12/10/2018","26/10/2018","swathi+","32","10","7","18P");
//                insertIntoDB("13/10/2018","27/10/2018","swathi+","36","19","8","59P");
//                insertIntoDB("14/10/2018","28/10/2018","swathi+","41","32","11","04P");
//                insertIntoDB("15/10/2018","29/10/2018","swathi+","47","36","1","31A");
//
//
//            } else {
//                Log.i("Notifications", "select data available Success");
//            }


        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("Notifications","StarDataBaseHelper onUpgrade start ");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

        Log.i("Notifications","ThiThiDataBaseHelper onUpgrade end ");
    }
    public void insertIntoDB(String english_date,String tamil_date,String star_name,String tamil_time_nalikai,
                             String tamil_time_vinadi, String english_time_hours, String english_time_minutes)

    {


        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COL_1,english_date);
        contentValues.put(COL_2,tamil_date);
        contentValues.put(COL_3,star_name);
        contentValues.put(COL_4,tamil_time_nalikai);
        contentValues.put(COL_5,tamil_time_vinadi);
        contentValues.put(COL_6,english_time_hours);
        contentValues.put(COL_7,english_time_minutes);


        long result=db.insert(TABLE_NAME,null,contentValues);


        if(result==-1)
        {

            Log.i("Notifications","starDataBaseHelper insertIntoDB Fails ");
        }
        else
        {

            Log.i("Notifications","starDataBaseHelper Success ");
        }
    }
    public Cursor getDataStarInfo(String Engdate,String t1, String t2, String e1, String e2 ){
        Log.i("Notifications","StarsDataBaseHelper select data available start");
        SQLiteDatabase db=this.getWritableDatabase();

        Log.i("Notifications", "Initail Value inserted to database");
        String sqleng = "select * from "+TABLE_NAME+ " where ENGLISH_DATE = " + "'"+Engdate+"'"+ " AND TAMIL_TIME_NALIKAI = " + "'"+t1+"'"+ " AND TAMIL_TIME_VINADI = " + "'"+t2+"'"+ " AND ENGLISH_TIME_HOUR = " + "'"+e1+"'"+ " AND ENGLISH_TIME_MINUTES = " + "'"+e2+"'";
        Cursor cur= db.rawQuery(sqleng,null);

        // Cursor cur= db.rawQuery("select * from Star_Info_table where ENGLISH_DATE = '19/10/2018'",null);

        if(cur.getCount()==0)
        {
            Log.i("Notifications","select data available Failure");

        }

        else
        {
            Log.i("Notifications","select data available Success");
        }

        while (cur.moveToNext())
        {
            Log.i("Notifications","select data available Success english_date"+cur.getString(0));
            Log.i("Notifications","select data available Success english_time"+cur.getString(1));
            Log.i("Notifications","select data available Success Star Name"+cur.getString(2));
            Log.i("Notifications","select data available Success tamil_time_nalikai"+cur.getString(3));
            Log.i("Notifications","select data available Success tamil_time_vinadi"+cur.getString(4));
        }

        Log.i("Notifications","select data available end");

        return cur;
    }

}
