package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by j on 9/13/17.
 */

public class EarthQuakeAdapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<EarthQuakeData> mData;

    public EarthQuakeAdapter(Context context, int resource, ArrayList<EarthQuakeData> arrayList){
        super(context,resource,arrayList);
        mContext = context;
        mData = arrayList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        EarthQuakeData currentQuake = mData.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.earthquake_list_layout,null );

        TextView cityName = (TextView) view.findViewById(R.id.City_text_view);
        TextView magnitude = (TextView) view.findViewById(R.id.Magnitude_text_view);
        TextView date = (TextView) view.findViewById(R.id.Date_text_view);

        GradientDrawable magCircle = (GradientDrawable) magnitude.getBackground();
        int magColor = getMagnitudeColor(currentQuake.getmMagnitude());
        magCircle.setColor(magColor);

        DecimalFormat formatter = new DecimalFormat("0.00");
        String mag = formatter.format(currentQuake.getmMagnitude());
        cityName.setText( currentQuake.getmLocation() );
        magnitude.setText( mag );
        date.setText( currentQuake.getmDateAsString() );

        return view;
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
