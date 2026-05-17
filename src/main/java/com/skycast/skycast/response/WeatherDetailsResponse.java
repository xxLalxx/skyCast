package com.skycast.skycast.response;

public class WeatherDetailsResponse {
	
	private double temperature;
	private String condition;
	private int humidity;
	private double windSpeed;
	private double feelsLike;
	private double visibility;
	private int aqi;
	private String time;
	
	public WeatherDetailsResponse(double temperature, String condition, int humidity, double windSpeed, double feelsLike,
			double visibility, int aqi, String time) {
		super();
		this.temperature = temperature;
		this.condition = condition;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		this.feelsLike = feelsLike;
		this.visibility = visibility;
		this.aqi = aqi;
		this.time = time;
	}

	public WeatherDetailsResponse() {
		super();
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}

	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}
