package com.skycast.skycast.dto;

public class DayForecast {

	private String dayOfWeek;      // e.g., "Mon"
    private String date;           // e.g., "2026-05-20"
    private double minTemp;        // e.g., 18.5
    private double maxTemp;        // e.g., 29.0
    private double avgTemp;        // e.g., 23.7
    private double windSpeed;      // e.g., 15.4
    private int humidity;          // e.g., 65
    private String condition;      // e.g., "Rainy"
    private String iconCode;       // e.g., "rain-icon"
    private int rainChance;        // e.g., 80
    
	public DayForecast(String dayOfWeek, String date, double minTemp, double maxTemp, double avgTemp, double windSpeed,
			int humidity, String condition, String iconCode, int rainChance) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.date = date;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.avgTemp = avgTemp;
		this.windSpeed = windSpeed;
		this.humidity = humidity;
		this.condition = condition;
		this.iconCode = iconCode;
		this.rainChance = rainChance;
	}
	public DayForecast() {
		super();
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}
	public double getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}
	public double getAvgTemp() {
		return avgTemp;
	}
	public void setAvgTemp(double avgTemp) {
		this.avgTemp = avgTemp;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getIconCode() {
		return iconCode;
	}
	public void setIconCode(String iconCode) {
		this.iconCode = iconCode;
	}
	public int getRainChance() {
		return rainChance;
	}
	public void setRainChance(int rainChance) {
		this.rainChance = rainChance;
	}
 
}
