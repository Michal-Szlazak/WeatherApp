package com.dev.WeatherApp.service;

import com.dev.WeatherApp.Location.Location;

public interface GeolocationService {

    Location[] getGeolocation(String location);
}
