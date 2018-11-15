package com.whatsapp.murali.mycalendar;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
// added comments
    StarsDataBaseHelper stardb;
    TextView starname;
    TextView starengdate;
    TextView startamdate;
    EditText tamilhor;
    EditText tamilmin;
    EditText enghor;
    EditText engmin;
    Button Get_star;
    String Englishdate;
    String tamildate;
    String starname1;
    String tamil_time;
    String English_time;

    String t1;
    String t2;
    String e1;
    String e2;


    String tamil_time_nalikai;
    String tamil_time_vinadi;
    String english_time_hours;
    String english_time_minutes;

    private ArrayList<String> results = new ArrayList<String>();
    String current_engdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        starname = findViewById(R.id.star_name);
        starengdate = findViewById(R.id.star_eng_date);
        startamdate = findViewById(R.id.star_tam_date);

        tamilhor = findViewById(R.id.tamilhor);
        tamilmin = findViewById(R.id.tamilmin);
        enghor = findViewById(R.id.enghor);
        engmin = findViewById(R.id.engmin);

        Get_star = findViewById(R.id.Get_star);

        stardb = new StarsDataBaseHelper(this);




        current_engdate = "19/10/2018";

        Get_star.setOnClickListener(this);



    }

    public void onClick(View v) {
        if (v == Get_star) {
            currentstar();
        }


    }

    public void currentstar() {

        t1 = tamilhor.getText().toString();
        t2 = tamilmin.getText().toString();

        e1 = enghor.getText().toString();
        e2 = engmin.getText().toString();

        try {
            stardb.getDataStarInfo(current_engdate, t1, t2, e1, e2);
            Cursor c = stardb.getDataStarInfo(current_engdate, t1, t2, e1, e2);


            if ((c.getCount()!=0)) {
                if (c.moveToFirst()) {
                    do {
                        Englishdate = c.getString(0);
                        tamildate = c.getString(1);
                        starname1 = c.getString(2);
                        tamil_time_nalikai = c.getString(3);
                        tamil_time_vinadi = c.getString(4);
                        english_time_hours = c.getString(5);
                        english_time_minutes = c.getString(6);

                        results.add("Englishdate: " + Englishdate + ",Tamildate: " + tamildate + ",Starname: " + starname1 + "tamil_time :" + tamil_time_nalikai + ":" + tamil_time_nalikai);


                    } while (c.moveToNext());
                }
                starname.setText(starname1);
                starengdate.setText(Englishdate);
                startamdate.setText(tamildate);
            }
            else {
                starname.setText("0");
                starengdate.setText("0");
                startamdate.setText("0");
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        }



    }


}