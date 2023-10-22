package com.dev.WeatherApp.weather;


import com.dev.WeatherApp.ObjectToJsonMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyWeatherData {

    @JsonProperty("time")
    private List<String> dates = new ArrayList<>();
    @JsonProperty("temperature_2m_max")
    private List<Long> maxTemperature = new ArrayList<>();
    @JsonProperty("temperature_2m_min")
    private List<Long> minTemperature = new ArrayList<>();
    @JsonProperty("apparent_temperature_max")
    private List<Long> apparentMaxTemperature = new ArrayList<>();
    @JsonProperty("apparent_temperature_min")
    private List<Long> apparentMinTemperature = new ArrayList<>();
    @JsonProperty("precipitation_sum")
    private List<Long> precipitationSum = new ArrayList<>();
    @JsonProperty("rain_sum")
    private List<Long> rainSum = new ArrayList<>();
    @JsonProperty("showers_sum")
    private List<Long> showersSum = new ArrayList<>();
    @JsonProperty("snowfall_sum")
    private List<Long> snowfallSum = new ArrayList<>();
    @JsonProperty("precipitation_probability_mean")
    private List<Long> precipitationProbabilityMean = new ArrayList<>();
    @JsonProperty("sunrise")
    private List<String> sunrise = new ArrayList<>();
    @JsonProperty("sunset")
    private List<String> sunset = new ArrayList<>();
    @JsonProperty("windspeed_10m_max")
    private List<Long> windSpeedMax = new ArrayList<>();

    public String toString() {
        return ObjectToJsonMapper.map(this);
    }
}
