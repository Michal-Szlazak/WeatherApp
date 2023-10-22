package com.dev.WeatherApp.service;

import com.dev.WeatherApp.Http.HttpDailyWeatherParameters;
import com.dev.WeatherApp.Http.HttpHourlyWeatherParameters;
import com.dev.WeatherApp.Http.HttpRequestHourlyWeatherBuilder;
import com.dev.WeatherApp.Location.Location;
import com.dev.WeatherApp.Http.HttpRequestDailyWeatherBuilder;
import com.dev.WeatherApp.weather.DailyWeatherData;
import com.dev.WeatherApp.weather.Day;
import com.dev.WeatherApp.weather.HourlyWeatherData;
import com.dev.WeatherApp.weather.Weather;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;
    private final Weather weather;
    private final HttpRequestDailyWeatherBuilder httpRequestDailyWeatherBuilder;
    private final HttpRequestHourlyWeatherBuilder httpRequestHourlyWeatherBuilder;

    public WeatherServiceImpl(RestTemplate restTemplate, Weather weather,
                              HttpRequestDailyWeatherBuilder httpRequestDailyWeatherBuilder,
                              HttpRequestHourlyWeatherBuilder httpRequestHourlyWeatherBuilder) {
        this.restTemplate = restTemplate;
        this.weather = weather;
        this.httpRequestDailyWeatherBuilder = httpRequestDailyWeatherBuilder;
        this.httpRequestHourlyWeatherBuilder = httpRequestHourlyWeatherBuilder;
    }

    @Override
    public Weather getDailyWeatherData(Location location) {

        String uri = httpRequestDailyWeatherBuilder.buildRequestForDailyData(
                HttpDailyWeatherParameters.getParameters(),
                location
        );
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode dailyNode = root.get("daily");
            DailyWeatherData dailyWeatherData = mapper.convertValue(dailyNode, DailyWeatherData.class);
            weather.loadDailyWeatherData(dailyWeatherData);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return weather;
    }

    @Override
    public Day getHourlyWeatherData(Location location, Day day) {

        String uri = httpRequestHourlyWeatherBuilder.buildRequestForHourlyData(
                HttpHourlyWeatherParameters.getParameters(),
                location,
                day
        );
        System.out.println(uri);
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode dailyNode = root.get("hourly");
            HourlyWeatherData hourlyWeatherData = mapper.convertValue(dailyNode, HourlyWeatherData.class);
            day.loadHourlyWeatherData(hourlyWeatherData);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return day;
    }
}
