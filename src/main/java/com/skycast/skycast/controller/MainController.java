package com.skycast.skycast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skycast.skycast.response.WeatherDetailsResponse;
import com.skycast.skycast.service.WeatherService;

@RestController
@RequestMapping("/v1/api/weather")
public class MainController {
	
	@Autowired
	WeatherService weatherService;
	
	@GetMapping("/city/current/{city}")
	public void getCurrentWeatherDetails() {}
	
	@GetMapping("/city/{city}")
	public WeatherDetailsResponse getCityWeatherDetails(String city) {
		return weatherService.getCurrentWeather(city);
	}

	@GetMapping("/forecast")
	public void getCityForecast() {}


}
