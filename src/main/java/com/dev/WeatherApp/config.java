package com.dev.WeatherApp;

import com.dev.WeatherApp.Http.HttpRequestGeolocationBuilder;
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
}
