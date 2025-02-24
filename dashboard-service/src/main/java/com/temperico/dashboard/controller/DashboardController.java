package com.temperico.dashboard.controller;

import com.temperico.dashboard.client.WeatherServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DashboardController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private WeatherServiceClient weatherServiceClient;

    @GetMapping("/")
    public String dashboard(Model model) {
        Map<String, Object> services = new HashMap<>();
        discoveryClient.getServices().forEach(serviceId -> {
            services.put(serviceId, discoveryClient.getInstances(serviceId));
        });
        model.addAttribute("services", services);

        try {
            Map<String, Object> weatherData = weatherServiceClient.getCurrentWeather("Madrid");
            model.addAttribute("weatherData", weatherData);
            model.addAttribute("weatherServiceStatus", "UP");
        } catch (Exception e) {
            model.addAttribute("weatherServiceStatus", "DOWN");
        }

        return "dashboard";
    }
}