package com.tts.mapsapp.service;

import com.tts.mapsapp.models.GeocodingResponse;
import com.tts.mapsapp.models.Location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {
    @Value("${api_key}")
    private String apiKey;

    public void addCoordinates(Location location) {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location.getCity() + ","
                + location.getState() + "&key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();

        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());
    }

    public Location randomCity() {
        Location randLocation = new Location();

        String randomLat = "";
        String randomLng = "";

        boolean locationExists = true;
        while (locationExists) {
            randomLat = String.valueOf(((Math.random() * 1800.0) / 10.0) - 90.0);
            randomLng = String.valueOf(((Math.random() * 3600.0) / 10.0) - 180.0);

            String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + randomLat + ","
                    + randomLng + "&key=" + apiKey;
            RestTemplate restTemplate = new RestTemplate();
            GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
            if (response.getResults().size() > 0) {
                randLocation = response.getResults().get(0).getGeometry().getLocation();
                locationExists = false;
            }
        }

        System.out.println("Coordinates: " + randLocation.getLat() + " " + randLocation.getLng());
        System.out.println("State: " + randLocation.getState());

        return randLocation;
    }
}