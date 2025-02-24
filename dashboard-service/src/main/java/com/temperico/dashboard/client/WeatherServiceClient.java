package com.temperico.dashboard.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@FeignClient(name = "weather-service")
public interface WeatherServiceClient {
    @GetMapping("/api/weather/current/{city}")
    Map<String, Object> getCurrentWeather(@PathVariable("city") String city);
}