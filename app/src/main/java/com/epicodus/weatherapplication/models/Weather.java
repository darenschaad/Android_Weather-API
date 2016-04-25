package com.epicodus.weatherapplication.models;

/**
 * Created by Guest on 4/25/16.
 */
public class Weather {
    private String mLocation;
    private String mDateTime;
    private String mDayTemp;
    private String mDayTempLow;
    private String mDayTempHigh;

    public Weather(String location, String dateTime, String dayTemp, String dayTempLow, String dayTempHigh) {
        this.mLocation = location;
        this.mDateTime = dateTime;
        this.mDayTemp = dayTemp;
        this.mDayTempLow = dayTempLow;
        this.mDayTempHigh = dayTempHigh;
    }

    public String getLocation() {
        return mLocation;
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
