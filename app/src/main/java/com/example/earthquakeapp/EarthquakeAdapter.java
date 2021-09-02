package com.example.earthquakeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

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
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the Magnitude translation from the currentWord object and set this text on
        // the Magnitude TextView.
        magnitudeTextView.setText(String.valueOf(earthquake.getMagnitude()));

        // Find the TextView in the earthquake_list_item.xml layout with the ID location.
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        // Get the Location translation from the currentWord object and set this text on
        // the Location TextView.
        locationTextView.setText(earthquake.getLocation());

        // Find the TextView in the earthquake_list_item.xml layout with the ID date.
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Get the Date translation from the currentWord object and set this text on
        // the Date TextView.
        dateTextView.setText(String.valueOf(earthquake.getDate()));

        return  listItemView;
    }
}
