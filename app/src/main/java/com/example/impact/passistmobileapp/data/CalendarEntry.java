package com.example.impact.passistmobileapp.data;

/**
 * Created by impact on 2016-07-02.
 */
public class CalendarEntry {
    long dtstart;
    long dtend;
    String title;
    String location;

    public CalendarEntry(String title, String location, long dtstart, long dtend) {
        this.dtstart = dtstart;
        this.dtend = dtend;
        this.title = title;
        this.location = location;
    }

    public long getDtstart() {
        return dtstart;
    }

    public void setDtstart(long dtstart) {
        this.dtstart = dtstart;
    }

    public long getDtend() {
        return dtend;
    }

    public void setDtend(long dtend) {
        this.dtend = dtend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
