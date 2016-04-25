package com.epicodus.weatherapplication.services;

import android.util.Log;

import com.epicodus.weatherapplication.Constants;
import com.epicodus.weatherapplication.models.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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

    public ArrayList<Weather> processResults(Response response) {
        ArrayList<Weather> weathers = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject openweatherJSON = new JSONObject(jsonData);
                JSONArray weathersJSON = openweatherJSON.getJSONArray("weathers");
                for (int i = 0; i < weathersJSON.length(); i++) {
                    JSONObject weatherJSON = weathersJSON.getJSONObject(i);
                    String name = weatherJSON.getString("name");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weathers;
    }
}
