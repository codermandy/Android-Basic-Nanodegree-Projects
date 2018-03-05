package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import android.graphics.drawable.GradientDrawable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by codermandy on 13/2/18.
 */

/**
 * @link Earthquake Adapter knows how to create a list item layout for each earthquake in data source
 * {list of @link Earthquake objects}
 *
 * These list item layout will provided to an adapter view like listview to be displayed to user
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{
    private static final String LOCATION_SEPARATOR = " of "; //global variable to seprate strings

    /**
     * @param context     of the app
     * @param earthquakes is the list of earthquakes,which is data source of adapter
     */
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if there is an existing list item view(convert view) that we can reuse
        //otherwise if convertView is null inflate a new list item layout
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);



            //Find the earthquake at a given position in list of earthquake
            Earthquake currentEarthquake = getItem(position);

            //Find TextView with view ID magnitude
            TextView magnitudeView =  listItemView.findViewById(R.id.magnitude);
            // Format the magnitude to show 1 decimal place
            String formattedMagnitude= formatMagnitude(currentEarthquake.getMagnitude());
            //Display magnitude of current earthquake in Text View
            magnitudeView.setText(formattedMagnitude);

            //Create a new Date Object from timeInMilliseconds of Earthquake
            Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

            //Find TextView with view ID date
            TextView dateView = (TextView)listItemView.findViewById(R.id.date);
            //Format the date String(ie. March 3,1984)
            String formattedDate = formatDate(dateObject);
            //Display date of current earthquake in Text View
            dateView.setText(formattedDate);

            //Find TextView with view ID time
            TextView timeView = (TextView) listItemView.findViewById(R.id.time);
            //Format the time String(ie. 4:30PM)
            String formattedTime = formatTime(dateObject);
            //Display time of that earthquake in Text View
            timeView.setText(formattedTime);

            //Gets earthquake location from currentEarthquake object and store it in variable
            String orignalLocation= currentEarthquake.getLocation();
            String primaryLocation;
            String locationOffset;
            if(orignalLocation.contains(LOCATION_SEPARATOR)){
                String[] parts=orignalLocation.split(LOCATION_SEPARATOR);   //original location String is “74km NW of Rumoi, Japan”
                locationOffset=parts[0]+LOCATION_SEPARATOR; //locationOffset will say “74km NW of “.
                primaryLocation=parts[1];   //1st element of the array is “Rumoi, Japan"
            }
            else{       // some location Strings don’t have a location offset.
                locationOffset= getContext().getString(R.string.near_the);
                primaryLocation=orignalLocation;
            }
            TextView locationOffsetView=listItemView.findViewById(R.id.location_offset);
            locationOffsetView.setText(locationOffset);

            TextView primaryLocationView=listItemView.findViewById(R.id.primary_location);
            primaryLocationView.setText(primaryLocation);

            // Set the proper background color on the magnitude circle.
            // Fetch the background from the TextView, which is a GradientDrawable.
            GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
            // Get the appropriate background color based on the current earthquake magnitude
            int magnitudeColor =  getMagnitudeColor(currentEarthquake.getMagnitude());


        }
        //Return list item that is now showing appropiate data
        return listItemView;

    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor=(int)Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId=R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId=R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId=R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId=R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId=R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId=R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId=R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId=R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId=R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId=R.color.magnitude10plus;
                break;
        }
                return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
    }

    private String formatTime(Date dateObject)
        {
            SimpleDateFormat timeFormat= new SimpleDateFormat("h:mm a");
            return timeFormat.format(dateObject);
        }

    /**
     *
     * @param dateObject
     * @return formatted date string
     */
    private String formatDate(Date dateObject) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd,yyyy");
            return dateFormat.format(dateObject);
        }

    /**
     *
     * @param magnitude of earthquake in double
     * @return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
        private String formatMagnitude(double magnitude){
            DecimalFormat magnitudeFormat=new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);

    }




}

