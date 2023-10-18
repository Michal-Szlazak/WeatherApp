package com.dev.WeatherApp.service;

import com.dev.WeatherApp.Http.HttpRequestGeolocationBuilder;
import com.dev.WeatherApp.Location.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class GeolocationServiceImpl implements GeolocationService {

    private final RestTemplate restTemplate;
    private final HttpRequestGeolocationBuilder httpRequestGeolocationBuilder;

    @Autowired
    public GeolocationServiceImpl(RestTemplate restTemplate, HttpRequestGeolocationBuilder httpRequestGeolocationBuilder) {
        this.restTemplate = restTemplate;
        this.httpRequestGeolocationBuilder = httpRequestGeolocationBuilder;
    }

    @Override
    public Location[] getGeolocation(String address) {

        String uri = httpRequestGeolocationBuilder.build(address);
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        Location[] locations = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            locations = mapper.readValue(response.getBody(), Location[].class);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return locations;

    }
}
