package com.example.android.quakereport;

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private long mDate;
    private String mUrl;

    /**
     * Creates new Word object
     *
     * @param magnitude - strength of quake
     * @param location      - place of quake
     * @param date      - mDate of quake
     */

    public Earthquake(double magnitude, String location, long date, String url) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mDate = date;
        this.mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }


    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getDate() {
        return mDate;
    }
}


