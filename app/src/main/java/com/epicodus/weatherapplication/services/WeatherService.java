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
                JSONArray listsJSON = openweatherJSON.getJSONArray("list");
                String name = openweatherJSON.getJSONObject("city").getString("name");

                for (int i = 0; i < listsJSON.length(); i++) {
                    JSONObject weatherJSON = listsJSON.getJSONObject(i);
                    Long dateTime= weatherJSON.getLong("dt") * 1000;
                    int dayTemp = weatherJSON.getJSONObject("temp").getInt("day");
                    int dayTempLow = weatherJSON.getJSONObject("temp").getInt("min");
                    int dayTempHigh = weatherJSON.getJSONObject("temp").getInt("max");

                    Weather weather = new Weather(name, dateTime, dayTemp, dayTempLow, dayTempHigh);
                    Log.d("WEATHER", weather.getName() + weather.getDayTemp());
                    weathers.add(weather);
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
