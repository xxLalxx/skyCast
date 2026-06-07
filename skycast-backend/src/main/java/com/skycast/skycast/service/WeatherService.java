package com.skycast.skycast.service;

import java.util.List;

import com.skycast.skycast.dto.DayForecast;
import com.skycast.skycast.response.WeatherDetailsResponse;

public interface WeatherService {
	
	WeatherDetailsResponse getCurrentWeather(String city);
	List<DayForecast> getCityForecast(String city);

}
