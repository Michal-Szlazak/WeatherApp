package com.dev.WeatherApp.controller;

import com.dev.WeatherApp.Location.Location;
import com.dev.WeatherApp.service.WeatherService;
import com.dev.WeatherApp.weather.Weather;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Controller
public class DailyWeatherController {

    private final HttpSession httpSession;
    private final WeatherService weatherService;
    private final Location location;

    @Autowired
    public DailyWeatherController(HttpSession httpSession, WeatherService weatherService, Location location) {
        this.httpSession = httpSession;
        this.weatherService = weatherService;
        this.location = location;
    }

    @PostMapping("/weather")
    public String getWeather(@ModelAttribute("selectedLocation") Location location, Model model) {

        this.location.setAddress(location.getAddress());
        this.location.setLongitude(location.getLongitude());
        this.location.setLatitude(location.getLatitude());
        httpSession.setAttribute("location", location);

        try {
            Weather weather = weatherService.getDailyWeatherData(location);
            httpSession.setAttribute("weather", weather);
            model.addAttribute("weather", weather);
            return "home";
        } catch (RuntimeException e) {
            Logger.getLogger("logger").info(e.getMessage());
        }
        return "redirect:/";
    }

}
