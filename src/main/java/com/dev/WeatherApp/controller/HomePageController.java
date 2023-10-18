package com.dev.WeatherApp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String goHome() {
        return "home";
    }

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
}
