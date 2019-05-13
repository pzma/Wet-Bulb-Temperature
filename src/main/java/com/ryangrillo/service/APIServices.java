package com.ryangrillo.service;

import com.ryangrillo.models.WeatherData;

public interface APIServices {
	
	String[] getGoogleMapsAPI(String zipCode);

	WeatherData getWeatherDataAPI(String[] latLong);
}
