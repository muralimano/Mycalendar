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


// basic template for inserting nalikai vinadi records
/*
insertIntoDB("0","0.30","0","0", "12");
        insertIntoDB("0","1","0","0", "24");

        insertIntoDB("0","1.30","0","0", "36");

        insertIntoDB("0","2.00","0","0", "48");

        insertIntoDB("0","2.30","0","1", "00");*/

public class TamilNalikaiViNadiDataBaseHelper  extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "TamilCalendar47.db";
    public static final String TABLE_NAME="Nalikai_Vinadi_Info_table";
    public static final String COL_1="TAMIL_TIME_NALIKAI";
    public static final String COL_2="TAMIL_TIME_VINADI";
    public static final String COL_3="ENGLISH_TIME_HOUR";
    public static final String COL_4="ENGLISH_TIME_MINUTES";
    public static final String COL_5="ENGLISH_TIME_SECONDS";


    public TamilNalikaiViNadiDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);



        SQLiteDatabase db=this.getWritableDatabase();

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
            //
            insertIntoDB("0","5.30","0","2", "12");
            insertIntoDB("0","6","0","2", "24");

            insertIntoDB("0","6.30","0","2", "36");

            insertIntoDB("0","7","0","2", "48");

            insertIntoDB("0","7.30","0","3", "00");
            //

            insertIntoDB("0","8","0","3", "12");
            insertIntoDB("0","8.30","0","3", "24");

            insertIntoDB("0","9","0","3", "36");

            insertIntoDB("0","9.30","0","3", "48");

            insertIntoDB("0","10","0","4", "00");
            //



        } else {
            Log.i("Notifications", "select data available Success");
        }

        // just invoked to test data inserted or not
        getNalikaiVinadi(null,null,null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.i("Notifications", "TamilNalikaiViNadiDataBaseHelper onCreate start ");
            //String sql = "create table " + TABLE_NAME + " (COL_1 TEXT PRIMARY KEY, COL_2 TEXT, COL_3 TEXT, COL_4 TEXT, COL_5 TEXT)";

            //  coulmn name in String so directly set the name instead from constant name
            /*String sql = "create table " + TABLE_NAME + " (TAMIL_TIME_NALIKAI TEXT , TAMIL_TIME_VINADI TEXT, ENGLISH_TIME_HOUR TEXT, ENGLISH_TIME_MINUTES TEXT, ENGLISH_TIME_SECONDS TEXT)";*/


           // String sql = "create table " + TABLE_NAME + " ("+TAMIL_TIME_NALIKAI+" TEXT , "+TAMIL_TIME_VINADI+" TEXT, "+ENGLISH_TIME_HOUR+" TEXT, "+ENGLISH_TIME_MINUTES+" TEXT, "+ENGLISH_TIME_SECONDS+" TEXT)";

            String sql = "create table " + TABLE_NAME + " ("+COL_1+" TEXT , "+COL_2+" TEXT, "+COL_3+" TEXT, "+COL_4+" TEXT, "+COL_5+" TEXT)";

            Log.i("Notifications", "TamilNalikaiViNadiDataBaseHelper sql " + sql);
            db.execSQL(sql);
            Log.i("Notifications", "TamilNalikaiViNadiDataBaseHelper onCreate end version" + db.getVersion());



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



    public String[] getNalikaiVinadi(String hours,String minutes,String seconds)
    {
        Log.i("Notifications"," getNalikaiVinadi where select data available start");
        SQLiteDatabase db=this.getWritableDatabase();


        Cursor cur= db.query(true,TABLE_NAME,null,null,null,null,null,null,null);

        if(cur.getCount()==0)
        {
            Log.i("Notifications","where select data available Failure");

        }

        else
        {
            Log.i("Notifications","where select data available Success");
        }

        String[] a=new String[5];
        String starName="";
        while (cur.moveToNext())
        {
            Log.i("Notifications","getNalikaiVinadi Success nalikai"+cur.getString(0));
            Log.i("Notifications","getNalikaiVinadi Success vinadi "+cur.getString(1));
            Log.i("Notifications","getNalikaiVinadi Success hours "+cur.getString(2));
            Log.i("Notifications","getNalikaiVinadi Success minutes"+cur.getString(3));
            Log.i("Notifications","getNalikaiVinadi Success seconds"+cur.getString(4));

            //   starName=cur.getString(2);

            a[0]=cur.getString(0);
            a[1]=cur.getString(1);
            a[2]=cur.getString(2);
            a[3]=cur.getString(3);
            a[4]=cur.getString(4);
        }

        Log.i("Notifications","getNalikaiVinadi where select data available end");

        return a;

    }


}


