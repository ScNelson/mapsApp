package com.tts.mapsapp.models;

public class Location {
    private String city;
    private String state;
    private String lat;
    private String lng;

    public Location() {}


    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "{" +
            " city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", lat='" + getLat() + "'" +
            ", lng='" + getLng() + "'" +
            "}";
    }
}
