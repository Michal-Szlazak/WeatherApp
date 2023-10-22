package com.dev.WeatherApp;

import com.dev.WeatherApp.Http.HttpHourlyWeatherParameters;
import com.dev.WeatherApp.Http.HttpRequestDailyWeatherBuilder;
import com.dev.WeatherApp.Http.HttpRequestGeolocationBuilder;
import com.dev.WeatherApp.Http.HttpRequestHourlyWeatherBuilder;
import com.dev.WeatherApp.Location.Location;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public HttpRequestGeolocationBuilder httpRequestGeolocationBuilder() {
        return new HttpRequestGeolocationBuilder();
    }
    @Bean
    public HttpRequestDailyWeatherBuilder httpRequestDailyWeatherBuilder() {
        return new HttpRequestDailyWeatherBuilder();
    }
    @Bean
    public HttpRequestHourlyWeatherBuilder httpRequestHourlyWeatherBuilder() {
        return new HttpRequestHourlyWeatherBuilder();
    }
    @Bean
    public Location location() {
        return new Location();
    }
}
