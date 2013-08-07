package org.test;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by npcompete on 7/8/13.
 */
public class Quake implements Parcelable {

    private Date date;
    private String details;
    private Location location;
    private double magnitude;
    private String link;

    public String getDetails() {
        return details;
    }

    public Location getLocation() {
        return location;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLink() {
        return link;
    }

    public Date getDate(){
        return this.date;
    }

    public Quake(Date _d, String _det, Location _loc, double _mag, String _link){
        this.date = _d;
        this.details = _det;
        this.location = _loc;
        this.magnitude = _mag;
        this.link = _link;
    }

    private Quake(Parcel in){
        this.date.setTime(in.readLong());
        this.details = in.readString();
        this.magnitude = in.readDouble();
        Location location = new Location("gps");
        location.setLatitude(in.readDouble());
        location.setLongitude(in.readDouble());
        this.link = in.readString();
    }

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH.mm");
        String dateString = sdf.format(date);
        return dateString+": "+magnitude+" "+details;
    }

    @Override
    public void writeToParcel(Parcel out,int flags){
        out.writeLong(date.getTime());
        out.writeString(details);
        out.writeDouble(magnitude);
        out.writeDouble(location.getLatitude());
        out.writeDouble(location.getLongitude());
        out.writeString(link);
    }
    public static final Parcelable.Creator<Quake> CREATOR = new Parcelable.Creator<Quake>(){
        @Override
        public Quake createFromParcel(Parcel in){
            return new Quake(in);
        }
        @Override
        public Quake[] newArray(int size){
            return new Quake[size];
        }
    };
    @Override
    public int describeContents(){
        return 0;
    }
}
