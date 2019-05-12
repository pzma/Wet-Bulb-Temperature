package com.ryangrillo.service;

import com.ryangrillo.models.GoogleAPIData;
import com.ryangrillo.models.WeatherData;

public interface APIServices {
	
	//WeatherData getWeatherDataAPI(String latitude, String longitude );

	GoogleAPIData getGoogleMapsAPI(String zipCode);

	WeatherData getWeatherDataAPI(GoogleAPIData googleAPIData);
}
