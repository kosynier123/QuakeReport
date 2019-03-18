package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, int resource, ArrayList<Earthquake> earthquakeArrayList) {
        super(context, resource, earthquakeArrayList);
    }

    @Override
    // null przy pierwszym otwarciu, inaczej zuzyte convertView zmieniaja sie w aktywne, layout inflatter normalnie by byl inicjowany w konstruktorze array adaptera
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //get both translation and image for each list item
        Earthquake localWord = getItem(position);
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView cityTextView = (TextView) listItemView.findViewById(R.id.city);
        TextView dateTextView =  (TextView) listItemView.findViewById(R.id.date);
        LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.linear);
        Double magnitude_double = (Double)localWord.getMagnitude();
        magnitudeTextView.setText(magnitude_double.toString());
        cityTextView.setText(localWord.getCity());
        dateTextView.setText((localWord.getDate()));
        return listItemView;
    }
}
