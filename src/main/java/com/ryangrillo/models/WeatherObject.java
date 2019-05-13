package com.ryangrillo.models;

public class WeatherObject {

	private String wetBulbGlobeTemp;
	
	private String temperature;
	
	private String relativeHumidity;

	public WeatherObject(String wetBulbGlobeTemp, String temperature, String relativeHumidity) {
		super();
		this.wetBulbGlobeTemp = wetBulbGlobeTemp;
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
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

	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}
	
	
}
