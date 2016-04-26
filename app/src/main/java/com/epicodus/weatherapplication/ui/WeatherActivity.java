package com.epicodus.weatherapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.epicodus.weatherapplication.R;
import com.epicodus.weatherapplication.models.Weather;
import com.epicodus.weatherapplication.services.WeatherService;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public ArrayList<Weather> mWeathers = new ArrayList<>();
    public static final String TAG = WeatherActivity.class.getSimpleName();
    @Bind(R.id.listView) ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getWeather(location);
    }

    private void getWeather(String location) {
        final WeatherService weatherService = new WeatherService();

        weatherService.findWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mWeathers = weatherService.processResults(response);

                WeatherActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] locationList = new String[mWeathers.size()];
                        for (int i = 0; i < locationList.length; i++) {
                            locationList[i] = Integer.toString(mWeathers.get(i).getDayTemp());
                    }
                        ArrayAdapter adapter = new ArrayAdapter(WeatherActivity.this, android.R.layout.simple_list_item_1, locationList);
                        mListView.setAdapter(adapter);

                        for (Weather weather : mWeathers) {
                            Log.d(TAG, "name" + weather.getName());
                            Log.d(TAG, "dateTime" + weather.getDateTime());
                        }
                    }
                });
            }
        });
    }
}
