package com.dev.WeatherApp.Http;

import com.dev.WeatherApp.Location.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class HttpRequestDailyWeatherBuilder {

    @Value("${weather.base-url}")
    private String baseUrl;
    public String buildRequestForDailyData(List<HttpParameter> params, Location location) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl);

        List<HttpParameter> httpParameters = new ArrayList<>(params);
        httpParameters.add(new HttpParameter("timezone", "Europe/Berlin"));
        httpParameters.add(new HttpParameter("longitude", Double.toString(location.getLongitude())));
        httpParameters.add(new HttpParameter("latitude", Double.toString(location.getLatitude())));

        for (HttpParameter parameter : httpParameters) {
            builder.queryParam(parameter.getKey(), parameter.getValue());
        }

        return builder.toUriString();
    }
}
