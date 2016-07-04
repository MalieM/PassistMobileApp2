package com.example.impact.passistmobileapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.impact.passistmobileapp.adapters.ItemsAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ItemsActivity extends AppCompatActivity {
    ItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        Intent intent = getIntent();
        int year = intent.getIntExtra("year", 2016);
        int month = intent.getIntExtra("month", 01);
        int day = intent.getIntExtra("day", 01);

        Toast.makeText(this, "Got: " + year + "-" + month + "-" + day, Toast.LENGTH_LONG).show();

        final ListView listview = (ListView) findViewById(R.id.listView);

        long start = new Date(year - 1900, month, day).getTime();
        long end = new Date(year - 1900, month, day).getTime() + 24*60*60*1000;

        adapter = new ItemsAdapter(this, start, end);
        //listview.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void toActivityMain(View view) {
        Intent listActivity = new Intent(this, MainActivity.class);
        startActivity(listActivity);
    }

    public void addNewEvent(View view) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");
        Calendar cal = Calendar.getInstance();

        long startTime = cal.getTimeInMillis();
        long endTime = cal.getTimeInMillis()  + 60 * 60 * 1000;
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
        intent.putExtra(CalendarContract.Events.DESCRIPTION,  "Event Description");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Location");
        //intent.putExtra(CalendarContract.Events.RRULE, "FREQ=YEARLY");
        startActivity(intent);
    }
}
