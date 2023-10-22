package com.dev.WeatherApp.Http;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class HttpDailyWeatherParameters {

    @Getter
    public static final List<HttpParameter> parameters;

    static {
        parameters = new ArrayList<>();
        parameters.add(new HttpParameter("daily", "temperature_2m_max"));
        parameters.add(new HttpParameter("daily", "temperature_2m_min"));
        parameters.add(new HttpParameter("daily", "apparent_temperature_max"));
        parameters.add(new HttpParameter("daily", "apparent_temperature_min"));
        parameters.add(new HttpParameter("daily", "precipitation_sum"));
        parameters.add(new HttpParameter("daily", "rain_sum"));
        parameters.add(new HttpParameter("daily", "showers_sum"));
        parameters.add(new HttpParameter("daily", "snowfall_sum"));
        parameters.add(new HttpParameter("daily", "precipitation_probability_mean"));
        parameters.add(new HttpParameter("daily", "sunrise"));
        parameters.add(new HttpParameter("daily", "sunset"));
        parameters.add(new HttpParameter("daily", "windspeed_10m_max"));
    }
}
