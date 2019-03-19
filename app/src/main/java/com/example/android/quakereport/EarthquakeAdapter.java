package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakeArrayList) {
        super(context, 0, earthquakeArrayList);
    }

    @Override
    // null przy pierwszym otwarciu, inaczej zuzyte convertView zmieniaja sie w aktywne, layout inflatter normalnie by byl inicjowany w konstruktorze array adaptera
    public View getView(int position, View convertView, ViewGroup parent) {
        final String LOC_SEPARATOR = "of ";
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }
        //get earthquake item
        Earthquake earthquake = getItem(position);
        // get textView for magnitude
        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude);
        // get textView for city
        TextView primaryLocationView = listItemView.findViewById(R.id.primaryLocation);
        // get textView for offset
        TextView offsetLocationView = listItemView.findViewById(R.id.offsetLocation);
        // get textView for date
        TextView dateTextView = listItemView.findViewById(R.id.date);
        // get textView for time
        TextView timeTextView = listItemView.findViewById(R.id.time);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        LinearLayout textContainer = listItemView.findViewById(R.id.linear);
        double magnitude_double = earthquake.getMagnitude();

        // populate magnitude textview
        magnitudeTextView.setText(formatMagnitude(magnitude_double));

        //get location and split it on primary and offset
        String[] location = earthquake.getLocation().split(LOC_SEPARATOR);

        if (location.length > 1) {
            //first value in location list is offset
            String offsetText = location[0] + LOC_SEPARATOR;
            offsetLocationView.setText(offsetText);
            primaryLocationView.setText(location[1]);
        } else {
            //if no offset provided - primary value is first in list and we need to add "near the"
            //for offset
            offsetLocationView.setText(R.string.near_the);
            primaryLocationView.setText(location[0]);
        }
        // populate date and time
        Date date = new Date(earthquake.getDate());
        // set text value
        dateTextView.setText(formatDate(date));
        //set time value
        timeTextView.setText(formatTime(date));

        return listItemView;
    }
    private String formatDate(Date date){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL dd, yyyy", Locale.US);
        return dateFormatter.format(date);
    }

    private String formatTime(Date date){
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a", Locale.US);
        return timeFormatter.format(date);
    }

    private String formatMagnitude(double magnitude){
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorId;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorId = R.color.magnitude9;
                break;
            default:
                magnitudeColorId = R.color.magnitude10plus;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorId);
    }
}
