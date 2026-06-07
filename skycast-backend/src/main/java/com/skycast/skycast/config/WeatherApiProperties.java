package com.skycast.skycast.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weather.api")
public class WeatherApiProperties {

	private String key;
	private String url;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public WeatherApiProperties() {
		super();
	}
	public WeatherApiProperties(String key, String url) {
		super();
		this.key = key;
		this.url = url;
	}
}
