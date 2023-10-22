package com.dev.WeatherApp.Http;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpParameter {

    public HttpParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    private String key;
    private String value;
}
