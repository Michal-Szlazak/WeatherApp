package com.dev.WeatherApp.Http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriComponentsBuilder;

public class HttpRequestGeolocationBuilder {

    @Value("${geocode.maps.co.base-url}")
    private String baseUrl;

    public String build(String address) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl);
        builder.queryParam("q", address);
        return builder.toUriString();
    }
}
