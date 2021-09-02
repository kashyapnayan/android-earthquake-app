package com.example.earthquakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake("6.5", "San Francisco, CA", "Sep 22, 2012"));
        earthquakes.add(new Earthquake("4.5", "San Francisco, CA", "Sep 13, 2013"));
        earthquakes.add(new Earthquake("5.5", "San Francisco, CA", "Sep 22, 2014"));
        earthquakes.add(new Earthquake("6.5", "San Francisco, CA", "Sep 22, 2015"));
        earthquakes.add(new Earthquake("4.5", "San Francisco, CA", "Sep 22, 2016"));
        earthquakes.add(new Earthquake("7.5", "San Francisco, CA", "Sep 22, 2017"));
        earthquakes.add(new Earthquake("6.5", "San Francisco, CA", "Sep 22, 2018"));
        earthquakes.add(new Earthquake("7.5", "San Francisco, CA", "Sep 22, 2019"));
        earthquakes.add(new Earthquake("9.5", "San Francisco, CA", "Sep 22, 2020"));
        earthquakes.add(new Earthquake("7.5", "San Francisco, CA", "Sep 22, 2021"));


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);
        earthquakeListView.setAdapter(adapter);
    }
}