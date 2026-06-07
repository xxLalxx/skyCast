package com.skycast.skycast.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.skycast.skycast.dto.DayForecast;
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
	
	public List<DayForecast> fromForecastApiResponse(Map<?, ?> rawResponse) {
	    List<DayForecast> forecastList = new ArrayList<>();
	    
	    if (rawResponse == null || !rawResponse.containsKey("forecast")) {
	        return forecastList;
	    }

	    // Drill down into forecast -> dayForecast
	    Map<?, ?> forecastContainer = (Map<?, ?>) rawResponse.get("forecast");
	    @SuppressWarnings("unchecked")
		List<Map<?, ?>> forecastDays = (List<Map<?, ?>>) forecastContainer.get("forecastday");

	    for (Map<?, ?> dayData : forecastDays) {
	        String rawDate = (String) dayData.get("date"); // e.g., "2026-05-20"
	        String parsedDayName = convertToDayName(rawDate); // e.g., "Wed"

	        Map<?, ?> dayMetrics = (Map<?, ?>) dayData.get("day");
	        Map<?, ?> conditionData = (Map<?, ?>) dayMetrics.get("condition");

	        // Create your object using your properties
	        DayForecast forecast = new DayForecast();
	        forecast.setDate(rawDate);
	        forecast.setDayOfWeek(parsedDayName);
	        forecast.setAvgTemp((Double) dayMetrics.get("avgtemp_c"));
	        forecast.setMaxTemp((Double) dayMetrics.get("maxtemp_c")); 
	        forecast.setMinTemp((Double) dayMetrics.get("mintemp_c"));
	        forecast.setHumidity(((Number) dayMetrics.get("avghumidity")).intValue());
	        forecast.setWindSpeed((Double) dayMetrics.get("maxwind_kph"));
	        
	        //Condition & Icon Details
	        if (conditionData != null) {
	            forecast.setCondition((String) conditionData.get("text"));
	            forecast.setIconCode((String) conditionData.get("icon"));
	        }

	        //Rain Chance
	        if (dayMetrics.containsKey("daily_chance_of_rain")) {
	            forecast.setRainChance(((Number) dayMetrics.get("daily_chance_of_rain")).intValue());
	        }
	        

	        forecastList.add(forecast);
	    }

	    return forecastList;
	}

	// turn dates into day names ("Mon", "Tue", etc.)
	private String convertToDayName(String dateStr) {
	    java.time.LocalDate date = java.time.LocalDate.parse(dateStr);
	    return date.getDayOfWeek().getDisplayName(java.time.format.TextStyle.SHORT, java.util.Locale.ENGLISH);
	}

}
