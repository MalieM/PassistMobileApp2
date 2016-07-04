package com.example.impact.passistmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView=(CalendarView) findViewById(R.id.calendarView1);
        calendarView.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //Toast.makeText(getApplicationContext(), ""+dayOfMonth, Toast.LENGTH_SHORT).show();// TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this, ItemsActivity.class);
                i.putExtra("year", year);
                i.putExtra("month", month);
                i.putExtra("day", dayOfMonth);
                startActivity(i);
            }
        });
    }

    public void toItemsList(View view) {
        Intent listActivity = new Intent(this,ItemsActivity.class);
        startActivity(listActivity);
    }
}
