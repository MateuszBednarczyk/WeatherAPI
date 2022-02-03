package com.example.weatherapi;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class WeatherAPI {

    @GetMapping("/pogoda/{city}")
    public WeatherModel[] getWeather(@PathVariable String city){

        RestTemplate restTemplate = new RestTemplate();
        WeatherModel[] weather = restTemplate.getForObject(
                "https://www.metaweather.com/api/location/search/?query="+city,
                WeatherModel[].class);

        for(WeatherModel weatherInfo: weather){
            System.out.println(weatherInfo.toString());
        }

        return weather;
    }
}
