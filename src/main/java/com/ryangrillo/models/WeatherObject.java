package com.ryangrillo.models;

public class WeatherObject {

	private String wetBulbGlobeTemp;
	
	private String temperature;
	
	private String humidity;

	public WeatherObject(String wetBulbGlobeTemp, String temperature, String humidity) {
		super();
		this.wetBulbGlobeTemp = wetBulbGlobeTemp;
		this.temperature = temperature;
		this.humidity = humidity;
	}

	public String getWetBulbGlobeTemp() {
		return wetBulbGlobeTemp;
	}

	public void setWetBulbGlobeTemp(String wetBulbGlobeTemp) {
		this.wetBulbGlobeTemp = wetBulbGlobeTemp;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	
	
}
