package model;

import java.io.Serializable;

public class Restaurant extends Place implements Serializable {

    private int stars;

    public Restaurant(String title, double lat, double lon, int stars){
        super(title, lat, lon);
        this.stars = stars;
    }

    public int getStars(){
        return stars;
    }

    public void setStars(int stars){
        this.stars = stars;
    }

    @Override
    public String toString(){
        return "Title: " + getTitle() + "\nLatitude: " + getLat() +
                "\nLongitude: " + getLon() + "\nStars: " + stars;
    }
}
