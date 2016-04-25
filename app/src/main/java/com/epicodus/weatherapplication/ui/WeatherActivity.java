package com.epicodus.weatherapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.weatherapplication.R;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
    }
}
