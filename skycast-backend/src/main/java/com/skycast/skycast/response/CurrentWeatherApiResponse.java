package com.skycast.skycast.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeatherApiResponse {
	
	private Location location;
	private Current current;
	
	
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Current getCurrent() {
		return current;
	}

	public void setCurrent(Current current) {
		this.current = current;
	}

	public static class Location{
		
		private String name;
		private String country;
		
		@JsonProperty("localtime")
		private String localTime;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getLocalTime() {
			return localTime;
		}
		public void setLocalTime(String localTime) {
			this.localTime = localTime;
		}		
	}
	
	public static class Current{
		
		@JsonProperty("temp_c")
		private double tempC;
		
		private Condition condition;
		
		private int humidity;

		@JsonProperty("wind_kph")
		private double windKph;
		
		@JsonProperty("feelslike_c")
		private double feelsLike;
		
		@JsonProperty("vis_km")
		private double visibilityKm;
		
		@JsonProperty("air_quality")
		private AirQuality airQuality; 
		
		@JsonProperty("last_updated")
		private String lastUpdated;

		public double getTempC() {
			return tempC;
		}

		public void setTempC(double tempC) {
			this.tempC = tempC;
		}

		public Condition getCondition() {
			return condition;
		}

		public void setCondition(Condition condition) {
			this.condition = condition;
		}

		public int getHumidity() {
			return humidity;
		}

		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}

		public double getWindKph() {
			return windKph;
		}

		public void setWindKph(double windKph) {
			this.windKph = windKph;
		}

		public double getFeelsLike() {
			return feelsLike;
		}

		public void setFeelsLike(double feelsLike) {
			this.feelsLike = feelsLike;
		}

		public double getVisibilityKm() {
			return visibilityKm;
		}

		public void setVisibilityKm(double visibilityKm) {
			this.visibilityKm = visibilityKm;
		}

		public AirQuality getAirQuality() {
			return airQuality;
		}

		public void setAirQuality(AirQuality airQuality) {
			this.airQuality = airQuality;
		}

		public String getLastUpdated() {
			return lastUpdated;
		}

		public void setLastUpdated(String lastUpdated) {
			this.lastUpdated = lastUpdated;
		}
		
		public static class Condition{
			private String text;

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
			
			
		} 
		
		public static class AirQuality{
			
			@JsonProperty("us-epa-index")
			private int usaEpaIndex;

			public int getUsaEpaIndex() {
				return usaEpaIndex;
			}

			public void setUsaEpaIndex(int usaEpaIndex) {
				this.usaEpaIndex = usaEpaIndex;
			}
			
			
		}
		
	}

}
