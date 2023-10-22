package com.dev.WeatherApp.Http;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class HttpHourlyWeatherParameters {

    @Getter
    public static final List<HttpParameter> parameters;

    static {
        parameters = new ArrayList<>();
        parameters.add(new HttpParameter("hourly", "temperature_2m"));
        parameters.add(new HttpParameter("hourly", "relativehumidity_2m"));
        parameters.add(new HttpParameter("hourly", "apparent_temperature"));
        parameters.add(new HttpParameter("hourly", "pressure_msl"));
        parameters.add(new HttpParameter("hourly", "cloudcover"));
        parameters.add(new HttpParameter("hourly", "windspeed_10m"));
        parameters.add(new HttpParameter("hourly", "precipitation"));
        parameters.add(new HttpParameter("hourly", "snowfall"));
        parameters.add(new HttpParameter("hourly", "precipitation_probability"));
        parameters.add(new HttpParameter("hourly", "rain"));
        parameters.add(new HttpParameter("hourly", "showers"));
        parameters.add(new HttpParameter("hourly", "visibility"));
    }

}
