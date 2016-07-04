package com.example.impact.passistmobileapp.adapters;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.impact.passistmobileapp.R;
import com.example.impact.passistmobileapp.data.CalendarEntry;

import java.util.ArrayList;
import java.util.Date;

public class ItemsAdapter extends BaseAdapter {

    Context context;
    ArrayList<CalendarEntry> calendar = new ArrayList<>();

    public ItemsAdapter(Context context, long startDateTime, long endDateTime) {
        this.context = context;

        Uri content = Uri.parse("content://com.android.calendar/events");
        String[] vec = new String[] { "calendar_id", "title", "description", "dtstart", "dtend", "allDay", "eventLocation" };
        String selectionClause = "(dtstart >= ? AND dtend <= ?)";
        String[] selectionsArgs = new String[]{"" + startDateTime, "" + endDateTime};

        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(content, vec, selectionClause, selectionsArgs, null);

        while (cursor.moveToNext()) {
            // read data from cursor and add to calendar
            //Log.d("date", "Got calendar ");

            CalendarEntry e = new CalendarEntry(cursor.getString(1),cursor.getString(2),cursor.getLong(3),cursor.getLong(4));
            calendar.add(e);
        }

        cursor.close();
    }

    @Override
    public int getCount() {
        return calendar.size();
    }

    @Override
    public CalendarEntry getItem(int position) {
        return calendar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_calendar_item, parent, false);
        }

        CalendarEntry e = getItem(position);
        TextView title = (TextView) convertView.findViewById(R.id.event_title);
        title.setText(e.getTitle());

        return convertView;
    }
}
