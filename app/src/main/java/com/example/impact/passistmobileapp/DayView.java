package com.example.impact.passistmobileapp;

import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

//import com.example.impact.passistmobileapp;

public class DayView extends AppCompatActivity {
    private static int HOURS_PER_DAY = 24;
    Context mContext = this;
    ListView list_view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getListView().setBackgroundColor(Color.rgb(12, 12, 12));
        getListView().setDividerHeight(0);
        setListAdapter(new ListAdapter(){

            @Override
            public boolean areAllItemsEnabled() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isEnabled(int arg0) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return HOURS_PER_DAY;
            }

            @Override
            public Object getItem(int arg0) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public long getItemId(int arg0) {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public int getItemViewType(int arg0) {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public View getView(int position, View arg1, ViewGroup arg2) {
                // TODO Auto-generated method stub
                LayoutInflater inflater = getLayoutInflater();
                View listItem = (View) inflater.inflate(R.layout.activity_day_view, getListView(),false);
                TextView hourTV = (TextView) listItem.findViewById(R.id.hourTV);
                TextView amTV = (TextView) listItem.findViewById(R.id.amTV);
                hourTV.setTextColor(Color.BLUE);
                amTV.setTextColor(Color.BLUE);
                final LinearLayout eventsLL = (LinearLayout) listItem.findViewById(R.id.eventsLL);
                hourTV.setText(String.valueOf((position+9)%24));
                //I set am/pm for each entry ... you could specify which entries
                if(((position>=0)&&(position<=2))||((position>=15)&&(position<=23)))
                    amTV.setText("am");
                else
                    amTV.setText("pm");

                return listItem;
            }

            @Override
            public int getViewTypeCount() {
                // TODO Auto-generated method stub
                return 1;
            }

            @Override
            public boolean hasStableIds() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean isEmpty() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver arg0) {
                // TODO Auto-generated method stub

            }

        });
    }

    private  ListView getListView() {
        return list_view;
    }

    private void setListAdapter(ListAdapter listAdapter) {
    }

    public void toDayView(View view) {
        // TODO Auto-generated method stub
        AlertDialog.Builder alert = new AlertDialog.Builder(mContext);

        alert.setTitle("New Event");
        alert.setMessage("Event:");

        // Set an EditText view to get user input
        final EditText input = new EditText(mContext);
        alert.setView(input);

        alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                TextView A = new TextView(mContext);
                A.setText(input.getText());
                A.setTextColor(Color.BLACK);
                LinearLayout lv = (LinearLayout) findViewById(R.id.eventsLL);
                lv.addView(A);
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }

    /**  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);
    }**/

}

