package com.example.android.quakereport;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by j on 9/13/17.
 */

public class EarthQuakeData {

    private String mLocation;
    private Double mMagnitude;
    private Long mDate;
    private URL mURL;

    EarthQuakeData(String loc, Double mag, Long date, String url){
        mLocation = loc;
        mMagnitude = mag;
        mDate = date;
        try{
            mURL = new URL(url);
        }catch(Exception e){
            mURL = null;
        }
    }

    EarthQuakeData(EarthQuakeData data){
        this.mLocation = data.getmLocation();
        this.mDate = data.getmDate();
        this.mMagnitude = data.getmMagnitude();
    }

    EarthQuakeData(){
        mLocation = "Default City";
        mDate = (long)1505336673;
        mMagnitude = 1.0;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public Double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(Double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public Long getmDate() {
        return mDate;
    }

    public String getmDateAsString(){
        Date date = new Date(mDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yy");
        return (String)dateFormat.format(date);
    }

    public void setmDate(Long mDate) {
        this.mDate = mDate;
    }

    public URL getUrl() {
        return mURL;
    }

    public void setUrl(URL url) {
        mURL = url;
    }
}
