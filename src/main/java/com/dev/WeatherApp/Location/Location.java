package com.dev.WeatherApp.Location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    @JsonProperty("display_name")
    private String address;

    @JsonProperty("lon")
    private float longitude;

    @JsonProperty("lat")
    private float latitude;

    @Override
    public String toString() {
        ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = "";
        try {
            result = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
