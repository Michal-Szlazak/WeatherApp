package com.dev.WeatherApp.controller;

import com.dev.WeatherApp.Location.Location;
import com.dev.WeatherApp.service.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GeolocationController {
    private final GeolocationService geolocationService;

    @Autowired
    public GeolocationController(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
    }

    @PostMapping("/geolocation/search")
    public String getGeolocation(Model model, @ModelAttribute("location") String address) {

        Location[] locations = geolocationService.getGeolocation(address);
        model.addAttribute("locations", locations);
        return "home";
    }

}
