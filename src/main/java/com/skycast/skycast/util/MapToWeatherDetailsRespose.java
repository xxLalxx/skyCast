package com.skycast.skycast.util;

import org.springframework.stereotype.Component;

import com.skycast.skycast.response.CurrentWeatherApiResponse;
import com.skycast.skycast.response.WeatherDetailsResponse;

@Component
public class MapToWeatherDetailsRespose {
	
	public WeatherDetailsResponse fromCurrentWeatherApiResponse(CurrentWeatherApiResponse response) {
		
		WeatherDetailsResponse weatherDetails = new WeatherDetailsResponse(); 
		weatherDetails.setAqi(response.getCurrent().getAirQuality().getUsaEpaIndex());
		weatherDetails.setCondition(response.getCurrent().getCondition().getText());
		weatherDetails.setFeelsLike(response.getCurrent().getFeelsLike());
		weatherDetails.setHumidity(response.getCurrent().getHumidity());
		weatherDetails.setTemperature(response.getCurrent().getTempC());
		weatherDetails.setTime(response.getLocation().getLocalTime());
		weatherDetails.setVisibility(response.getCurrent().getVisibilityKm());
		weatherDetails.setWindSpeed(response.getCurrent().getWindKph());
		
		return weatherDetails;
	}

}
