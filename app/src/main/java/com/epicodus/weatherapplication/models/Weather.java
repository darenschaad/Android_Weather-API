package com.epicodus.weatherapplication.models;

/**
 * Created by Guest on 4/25/16.
 */
public class Weather {
    private String mName;
    private String mDateTime;
    private String mDayTemp;
    private String mDayTempLow;
    private String mDayTempHigh;

    public Weather(String name, String dateTime, String dayTemp, String dayTempLow, String dayTempHigh) {
        this.mName = name;
        this.mDateTime = dateTime;
        this.mDayTemp = dayTemp;
        this.mDayTempLow = dayTempLow;
        this.mDayTempHigh = dayTempHigh;
    }

    public String getName() {
        return mName;
    }

    public String getDateTime() {
        return mDateTime;
    }

    public String getDayTemp() {
        return mDayTemp;
    }

    public String getDayTempLow() {
        return mDayTempLow;
    }

    public String getDayTempHigh() {
        return mDayTempHigh;
    }
}
