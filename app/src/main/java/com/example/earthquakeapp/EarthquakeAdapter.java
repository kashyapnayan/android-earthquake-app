package com.example.earthquakeapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

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

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        String[] loc = earthquake.getLocation().split("of ");
        if(loc.length == 2){
            // Find the TextView in the earthquake_list_item.xml layout with the ID area.
            TextView areaTextView =  listItemView.findViewById(R.id.location_offset);
            // Get the area translation from the currentWord object and set this text on
            // the area TextView.
            areaTextView.setText(loc[0] + "of ");

            // Find the TextView in the earthquake_list_item.xml layout with the ID location.
            TextView locationTextView =  listItemView.findViewById(R.id.primary_location);
            // Get the Location translation from the currentWord object and set this text on
            // the Location TextView.
            locationTextView.setText(loc[1]);
        }else {
            // Find the TextView in the earthquake_list_item.xml layout with the ID area.
            TextView areaTextView =  listItemView.findViewById(R.id.location_offset);
            // Get the area translation from the currentWord object and set this text on
            // the area TextView.
            areaTextView.setText(loc[0]);

            // Find the TextView in the earthquake_list_item.xml layout with the ID location.
            TextView locationTextView =  listItemView.findViewById(R.id.primary_location);
            locationTextView.setVisibility(View.INVISIBLE);
        }

        // Find the TextView in the earthquake_list_item.xml layout with the ID date.
        TextView dateTextView =  listItemView.findViewById(R.id.date);
        TextView timeTextView =  listItemView.findViewById(R.id.time);
        // Get the Date translation from the currentWord object and set this text on
        // the Date TextView.

        long timeInMilliseconds = earthquake.getDate();
        Date dateObject = new Date(timeInMilliseconds);

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM dd, yyyy HH:mm:ss");
        String formattedDateTime = dateFormatter.format(dateObject);


        String date = formattedDateTime.substring(0,11);
        String time = formattedDateTime.substring(12,17);

        dateTextView.setText(date);
        timeTextView.setText(time);

        return  listItemView;
    }


    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
