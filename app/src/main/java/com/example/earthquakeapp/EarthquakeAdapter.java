package com.example.earthquakeapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0 ,earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);

        // Find the TextView in the earthquake_list_item.xml layout with the ID magnitude.
        TextView magnitudeTextView =  listItemView.findViewById(R.id.magnitude);
        // Get the Magnitude translation from the currentWord object and set this text on
        // the Magnitude TextView.
        magnitudeTextView.setText(String.valueOf(earthquake.getMagnitude()));

        // Find the TextView in the earthquake_list_item.xml layout with the ID location.
        TextView locationTextView =  listItemView.findViewById(R.id.location);
        // Get the Location translation from the currentWord object and set this text on
        // the Location TextView.
        locationTextView.setText(earthquake.getLocation());

        // Find the TextView in the earthquake_list_item.xml layout with the ID date.
        TextView dateTextView =  listItemView.findViewById(R.id.date);
        // Get the Date translation from the currentWord object and set this text on
        // the Date TextView.

        long timeInMilliseconds = earthquake.getDate();
        Date dateObject = new Date(timeInMilliseconds);

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM dd, yyyy");
        String actualDate = dateFormatter.format(dateObject);

        dateTextView.setText(actualDate);

        return  listItemView;
    }
}
