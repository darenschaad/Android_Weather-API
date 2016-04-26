package com.epicodus.weatherapplication.models;

/**
 * Created by Guest on 4/25/16.
 */
public class Weather {
    private String mName;
    private long mDateTime;
    private int mDayTemp;
    private int mDayTempLow;
    private int mDayTempHigh;

    public Weather(String name, long dateTime, int dayTemp, int dayTempLow, int dayTempHigh) {
        this.mName = name;
        this.mDateTime = dateTime;
        this.mDayTemp = dayTemp;
        this.mDayTempLow = dayTempLow;
        this.mDayTempHigh = dayTempHigh;
    }

    public String getName() {
        return mName;
    }

    public long getDateTime() {
        return mDateTime;
    }

    public int getDayTemp() {
        return mDayTemp;
    }

    public int getDayTempLow() {
        return mDayTempLow;
    }

    public int getDayTempHigh() {
        return mDayTempHigh;
    }
}
