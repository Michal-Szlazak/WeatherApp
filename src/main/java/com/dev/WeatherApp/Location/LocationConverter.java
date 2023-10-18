package com.dev.WeatherApp.Location;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter implements Converter<String, Location> {

    @Override
    public Location convert(String source) {

        ObjectMapper mapper = new ObjectMapper();
        Location result = null;
        try {
            result = mapper.readValue(source, Location.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
