package com.example.earthquakeapp;

public class Earthquake {

    private final double mMagnitude;

    private final String mLocation;

    private final Long mDate;

    public Earthquake(double mMagnitude, String mLocation, Long mDate) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mDate = mDate;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public Long getDate() {
        return mDate;
    }
}
