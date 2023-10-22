package com.dev.WeatherApp.weather;

import com.dev.WeatherApp.ObjectToJsonMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Getter
@Setter
@Builder
public class Day {

    private String date;
    private Long maxTemperature;
    private Long minTemperature;
    private Long apparentMaxTemperature;
    private Long apparentMinTemperature;
    private Long precipitationSum;
    private Long rainSum;
    private Long showersSum;
    private Long snowfallSum;
    private Long precipitationProbabilityMean;
    private String sunrise;
    private String sunset;
    private Long windSpeedMax;
    private Map<String, Hour> hours;
    private List<Hour> hourValues;

    public void loadHourlyWeatherData(HourlyWeatherData hourlyWeatherData) {

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale.ENGLISH);

        hours = new TreeMap<>();

        int numberOfDays = hourlyWeatherData.getTimes().size();

        List<String> times = hourlyWeatherData.getTimes();
        List<Long> temperature = hourlyWeatherData.getTemperature();
        List<Long> humidity = hourlyWeatherData.getHumidity();
        List<Long> apparentTemperature = hourlyWeatherData.getApparentTemperature();
        List<Long> pressure = hourlyWeatherData.getPressure();
        List<Long> cloudCover = hourlyWeatherData.getCloudCover();
        List<Long> windSpeed = hourlyWeatherData.getWindSpeed();
        List<Long> precipitation = hourlyWeatherData.getPrecipitation();
        List<Long> snowfall = hourlyWeatherData.getSnowfall();
        List<Long> precipitationProbability = hourlyWeatherData.getPrecipitationProbability();
        List<Long> rain = hourlyWeatherData.getRain();
        List<Long> showers = hourlyWeatherData.getShowers();
        List<Long> visibility = hourlyWeatherData.getVisibility();


        for(int i = 0; i < numberOfDays; i++) {

            String inputTime = times.get(i);
            LocalDateTime dateTime = LocalDateTime.parse(inputTime, inputFormatter);
            String formattedTime = dateTime.format(outputFormatter);

            Hour hour = Hour.builder()
                    .time(formattedTime)
                    .temperature(temperature.get(i))
                    .humidity(humidity.get(i))
                    .apparentTemperature(apparentTemperature.get(i))
                    .pressure(pressure.get(i))
                    .cloudCover(cloudCover.get(i))
                    .windSpeed(windSpeed.get(i))
                    .precipitation(precipitation.get(i))
                    .snowfall(snowfall.get(i))
                    .precipitationProbability(precipitationProbability.get(i))
                    .rain(rain.get(i))
                    .showers(showers.get(i))
                    .visibility(visibility.get(i))
                    .build();

            hours.put(times.get(i), hour);
        }

        hourValues = new ArrayList<>(hours.values());
    }

    public String toString() {
        return ObjectToJsonMapper.map(this);
    }

}
