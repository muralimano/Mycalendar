package com.whatsapp.murali.mycalendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by KaGee on 11/17/2018.
 */


/*
insertIntoDB("0","0.30","0","0", "12");
        insertIntoDB("0","1","0","0", "24");

        insertIntoDB("0","1.30","0","0", "36");

        insertIntoDB("0","2.00","0","0", "48");

        insertIntoDB("0","2.30","0","1", "00");*/

public class TamilNalikaiViNadiDataBaseHelper  extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "TamilNalikaiVinadi.db";
    public static final String TABLE_NAME="Nalikai_Vinadi_Info_table";
    public static final String COL_1="TAMIL_TIME_NALIKAI";
    public static final String COL_2="TAMIL_TIME_VINADI";
    public static final String COL_3="ENGLISH_TIME_HOUR";
    public static final String COL_4="ENGLISH_TIME_MINUTES";
    public static final String COL_5="ENGLISH_TIME_SECONDS";


    public TamilNalikaiViNadiDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.i("Notifications", "TamilNalikaiViNadiDataBaseHelper onCreate start ");
            //String sql = "create table " + TABLE_NAME + " (COL_1 TEXT PRIMARY KEY, COL_2 TEXT, COL_3 TEXT, COL_4 TEXT, COL_5 TEXT)";

            String sql = "create table " + TABLE_NAME + " (COL_1 TEXT , COL_2 TEXT, COL_3 TEXT, COL_4 TEXT, COL_5 TEXT)";
            Log.i("Notifications", "TamilNalikaiViNadiDataBaseHelper sql " + sql);
            db.execSQL(sql);
            Log.i("Notifications", "TamilNalikaiViNadiDataBaseHelper onCreate end version" + db.getVersion());

            Cursor cur = db.rawQuery("select * from " + TABLE_NAME, null);

            if (cur.getCount() == 0) {

                insertIntoDB("0","0","0","0", "0");
               insertIntoDB("0","0","0","0", "1");
                insertIntoDB("0","0","0","0", "2");
                insertIntoDB("0","0","0","0", "3");
                insertIntoDB("0","0","0","0", "4");
                insertIntoDB("0","0","0","0", "5");
                insertIntoDB("0","0","0","0", "6");
                insertIntoDB("0","0","0","0", "7");
                insertIntoDB("0","0","0","0", "8");
                insertIntoDB("0","0","0","0", "9");
                insertIntoDB("0","0","0","0", "10");
                insertIntoDB("0","0","0","0", "11");
                insertIntoDB("0","0.30","0","0", "12");
                insertIntoDB("0","0.30","0","0", "13");
                insertIntoDB("0","0.30","0","0", "14");
                insertIntoDB("0","0.30","0","0", "15");
                insertIntoDB("0","0.30","0","0", "16");
                insertIntoDB("0","0.30","0","0", "17");
                insertIntoDB("0","0.30","0","0", "18");
                insertIntoDB("0","0.30","0","0", "19");
                insertIntoDB("0","0.30","0","0", "20");
                insertIntoDB("0","0.30","0","0", "21");
                insertIntoDB("0","0.30","0","0", "22");
                insertIntoDB("0","0.30","0","0", "23");
                insertIntoDB("0","1","0","0", "24");

                insertIntoDB("0","1.30","0","0", "36");

                insertIntoDB("0","2.00","0","0", "48");

                insertIntoDB("0","2.30","0","1", "00");

                insertIntoDB("0","3","0","1", "12");
                insertIntoDB("0","3.30","0","1", "24");

                insertIntoDB("0","4","0","1", "36");

                insertIntoDB("0","4.30","0","1", "48");

                insertIntoDB("0","5","0","2", "00");







            } else {
                Log.i("Notifications", "select data available Success");
           }

        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("Notifications","TamilNalikaiViNadiDataBaseHelper onUpgrade start ");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

        Log.i("Notifications","TamilNalikaiViNadiDataBaseHelper onUpgrade end ");
    }


    public void insertIntoDB(String nalikai,String vinadi,String hours,String minutes,
                             String seconds)

    {


        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COL_1,nalikai);
        contentValues.put(COL_2,vinadi);
        contentValues.put(COL_3,hours);
        contentValues.put(COL_4,minutes);
        contentValues.put(COL_5,seconds);



        long result=db.insert(TABLE_NAME,null,contentValues);


        if(result==-1)
        {

            Log.i("Notifications","TamilNalikaiViNadiDataBaseHelper insertIntoDB Fails ");
        }
        else
        {

            Log.i("Notifications","TamilNalikaiViNadiDataBaseHelper Success ");
        }
    }

}


