package com.dev.WeatherApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ObjectToJsonMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String map(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null.");
        }

        ObjectWriter mapper = objectMapper.writer().withDefaultPrettyPrinter();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error mapping object to JSON.", e);
        }
    }
}
