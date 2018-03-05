package com.example.android.quakereport;
/**
 * Created by codermandy on 13/2/18.
 */

/**
 * Constructs a new {@link Earthquake} object
 */
public class Earthquake {
    /*Magnitude of Earthquake*/
    private double mMagnitude;
    /*Location of Earthquake*/
    private String mLocation;
    /* Time of the earthquake */
    private long mTimeInMilliseconds;/*date when Earthquake occured*/
    /* Website url of earthquake*/
    private String mUrl;


   /**
           * Constructs a new {@link Earthquake} object.
   *
           * @param magnitude is the magnitude (size) of the earthquake
   * @param location is the city location of the earthquake
   * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
   *  earthquake happened
        */
    public Earthquake(double magnitude, String location, long timeInMilliseconds,String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }
    /**
     * @return magnitude
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * @return location
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * @return date
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     *
     * @return Website url to find more information about earthquake
     */
    public String getUrl(){return mUrl;}
}