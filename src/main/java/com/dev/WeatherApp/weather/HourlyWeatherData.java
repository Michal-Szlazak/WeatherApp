package com.dev.WeatherApp.weather;

import com.dev.WeatherApp.ObjectToJsonMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class HourlyWeatherData {

    @JsonProperty("time")
    private List<String> times = new ArrayList<>();
    @JsonProperty("temperature_2m")
    private List<Long> temperature = new ArrayList<>();
    @JsonProperty("relativehumidity_2m")
    private List<Long> humidity = new ArrayList<>();
    @JsonProperty("apparent_temperature")
    private List<Long> apparentTemperature = new ArrayList<>();
    @JsonProperty("pressure_msl")
    private List<Long> pressure = new ArrayList<>();
    @JsonProperty("cloudcover")
    private List<Long> cloudCover = new ArrayList<>();
    @JsonProperty("windspeed_10m")
    private List<Long> windSpeed = new ArrayList<>();
    @JsonProperty("precipitation")
    private List<Long> precipitation = new ArrayList<>();
    @JsonProperty("snowfall")
    private List<Long> snowfall = new ArrayList<>();
    @JsonProperty("precipitation_probability")
    private List<Long> precipitationProbability = new ArrayList<>();
    @JsonProperty("rain")
    private List<Long> rain = new ArrayList<>();
    @JsonProperty("showers")
    private List<Long> showers = new ArrayList<>();
    @JsonProperty("visibility")
    private List<Long> visibility = new ArrayList<>();

    public String toString() {
        return ObjectToJsonMapper.map(this);
    }

}
