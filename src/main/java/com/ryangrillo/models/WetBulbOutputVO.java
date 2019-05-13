package com.ryangrillo.models;

public class WetBulbOutputVO {
	 
	 private LocationObject location;
	 
	 private WeatherObject weather;

	public WetBulbOutputVO(LocationObject location, WeatherObject weather) {
		super();
		this.location = location;
		this.weather = weather;
	}

	public LocationObject getLocation() {
		return location;
	}

	public void setLocation(LocationObject location) {
		this.location = location;
	}

	public WeatherObject getWeather() {
		return weather;
	}

	public void setWeather(WeatherObject weather) {
		this.weather = weather;
	}

	
	 
	 
}