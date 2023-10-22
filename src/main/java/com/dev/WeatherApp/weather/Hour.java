package com.dev.WeatherApp.weather;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Hour {

    private String time;
    private Long temperature;
    private Long humidity;
    private Long apparentTemperature;
    private Long pressure;
    private Long cloudCover;
    private Long windSpeed;
    private Long precipitation;
    private Long snowfall;
    private Long precipitationProbability;
    private Long rain;
    private Long showers;
    private Long visibility;
}
