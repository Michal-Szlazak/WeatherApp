package com.dev.WeatherApp.controller;

import com.dev.WeatherApp.Location.Location;
import com.dev.WeatherApp.service.WeatherService;
import com.dev.WeatherApp.weather.Day;
import com.dev.WeatherApp.weather.Weather;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dailyWeather")
public class HourlyWeatherController {

    private HttpSession httpSession;
    private WeatherService weatherService;

    @Autowired
    public HourlyWeatherController(HttpSession httpSession, WeatherService weatherService) {
        this.httpSession = httpSession;
        this.weatherService = weatherService;
    }

    public HourlyWeatherController() {}

    @GetMapping("/showForm")
    public String loadHourlyWeatherForm(@RequestParam("date") String date,
                                        Model model) {
        Location location = (Location) httpSession.getAttribute("location");
        Weather weather = (Weather) httpSession.getAttribute("weather");

        Day day = weatherService.getHourlyWeatherData(location, weather.getDay(date));
        model.addAttribute("day", day);
        return "hourly-weather";
    }

}
