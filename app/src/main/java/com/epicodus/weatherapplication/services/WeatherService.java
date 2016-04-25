package com.epicodus.weatherapplication.services;

import android.util.Log;

import com.epicodus.weatherapplication.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by Guest on 4/25/16.
 */
public class WeatherService {
    public static void findWeather(String location, Callback callback) {
        String KEY = Constants.API_KEY;

        OkHttpClient client = new OkHttpClient.Builder()
            .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.WEATHER_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.WEATHER_LOCATION_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.WEATHER_API_KEY_QUERY_PARAMETER, KEY);
        String url = urlBuilder.build().toString();
//        url += "&appid=" + KEY;
        Log.d("URL", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
