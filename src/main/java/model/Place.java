package model;

import java.io.Serializable;

public abstract class Place implements Serializable {

    private String title;
    private double lat;
    private double lon;

    public Place(String title, double lat, double lon){
        this.title = title;
        this.lat = lat;
        this.lon = lon;
    }

    public String getTitle() {
        return title;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
