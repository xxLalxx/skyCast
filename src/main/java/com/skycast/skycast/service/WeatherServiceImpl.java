package com.skycast.skycast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.skycast.skycast.config.WeatherApiProperties;
import com.skycast.skycast.response.CurrentWeatherApiResponse;
import com.skycast.skycast.response.WeatherDetailsResponse;
import com.skycast.skycast.util.MapToWeatherDetailsRespose;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	private final WeatherApiProperties weatherApiProperties;
	private final WebClient webClient;
	
	public WeatherServiceImpl(WeatherApiProperties weatherApiProperties, WebClient webClient) {
		this.weatherApiProperties = weatherApiProperties;
		this.webClient = webClient;
	}
	
	@Autowired
	MapToWeatherDetailsRespose mapToWeatherDetailsRespose;

	@Override
	public WeatherDetailsResponse getCurrentWeather(String city) {
		
		CurrentWeatherApiResponse weatherDetails = webClient.get()
				.uri(uriBuilder->uriBuilder
						.path("/current.json")
						.queryParam("key", weatherApiProperties.getKey())
						.queryParam("q", city)
						.queryParam("aqi", "yes")
						.build())
				.retrieve()
				.bodyToMono(CurrentWeatherApiResponse.class)
				.block();
		return mapToWeatherDetailsRespose.fromCurrentWeatherApiResponse(weatherDetails);
	}

}
