package com.tts.mapsapp.models;

public class Geocoding {
    private Geometry geometry;


    public Geocoding() {}


    public Geometry getGeometry() {
        return this.geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }


    @Override
    public String toString() {
        return "{" +
            " geometry='" + getGeometry() + "'" +
            "}";
    }

}
