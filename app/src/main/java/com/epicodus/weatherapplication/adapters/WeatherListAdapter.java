package com.epicodus.weatherapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.weatherapplication.R;
import com.epicodus.weatherapplication.models.Weather;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 4/26/16.
 */
public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder> {
    private ArrayList<Weather> mWeathers = new ArrayList<>();
    private Context mContext;

    public WeatherListAdapter(Context context, ArrayList<Weather> weathers) {
        mContext = context;
        mWeathers = weathers;
    }

    @Override
    public WeatherListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherListAdapter.WeatherViewHolder holder, int position) {
        holder.bindWeather(mWeathers.get(position));
    }

    @Override
    public int getItemCount() {
        return mWeathers.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.dateTextView) TextView mDateTextView;
        @Bind(R.id.highTempTextView) TextView mHighTempTextView;
        @Bind(R.id.lowTempTextView) TextView mLowTempTextView;
        private Context mContext;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }

        public void bindWeather(Weather weather) {
            String date = new java.text.SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date(weather.getDateTime()));
            mDateTextView.setText(date);
            mHighTempTextView.setText("High Temp: " + weather.getDayTempHigh() + " F");
            mLowTempTextView.setText("Low Temp: " +weather.getDayTempLow() + " F");
        }
    }
}
