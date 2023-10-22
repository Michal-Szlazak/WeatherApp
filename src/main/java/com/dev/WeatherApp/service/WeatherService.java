package com.dev.WeatherApp.service;

import com.dev.WeatherApp.Location.Location;
import com.dev.WeatherApp.weather.Day;
import com.dev.WeatherApp.weather.Weather;

public interface WeatherService {

    Weather getDailyWeatherData(Location location);

    Day getHourlyWeatherData(Location location, Day day);

}
