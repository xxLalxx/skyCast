package com.skycast.skycast.service;

import com.skycast.skycast.response.WeatherDetailsResponse;

public interface WeatherService {
	
	WeatherDetailsResponse getCurrentWeather(String city);

}
