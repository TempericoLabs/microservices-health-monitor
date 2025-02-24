package com.temperico.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final Random random = new Random();

    @GetMapping("/current/{city}")
    public Map<String, Object> getCurrentWeather(@PathVariable String city) {
        // Simulando datos del clima
        Map<String, Object> weatherData = new HashMap<>();
        weatherData.put("city", city);
        weatherData.put("temperature", 15 + random.nextInt(20));
        weatherData.put("humidity", 30 + random.nextInt(70));
        weatherData.put("windSpeed", random.nextInt(30));
        weatherData.put("condition", getRandomCondition());
        return weatherData;
    }

    private String getRandomCondition() {
        String[] conditions = {"Sunny", "Cloudy", "Rainy", "Snowy", "Windy"};
        return conditions[random.nextInt(conditions.length)];
    }
}