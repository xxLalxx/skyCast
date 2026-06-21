package com.skycast.skycast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skycast.skycast.dto.DayForecast;
import com.skycast.skycast.response.WeatherDetailsResponse;
import com.skycast.skycast.service.WeatherService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/api/weather")
public class MainController {
	
	@Autowired
	WeatherService weatherService;
	
	@GetMapping("/city/current/{city}")
	public WeatherDetailsResponse getCurrentWeatherDetails(String city) {
		return weatherService.getCurrentWeather(city);
	}
	
	@GetMapping("/city/{city}")
	public WeatherDetailsResponse getCityWeatherDetails(String city) {
		return weatherService.getCurrentWeather(city);
	}

	@GetMapping("/forecast/{city}")
	public List<DayForecast> getCityForecast(String city) {
		return weatherService.getCityForecast(city);
	}


}
