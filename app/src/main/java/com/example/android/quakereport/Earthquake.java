package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private String city;
    private String date;

    /**
     * Creates new Word object
     * @param magnitude - strength of quake
     * @param city - place of quake
     * @param date - date of quake
     */

    public Earthquake(double magnitude, String city, String date){
        this.magnitude = magnitude;
        this.city = city;
        this.date = date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
