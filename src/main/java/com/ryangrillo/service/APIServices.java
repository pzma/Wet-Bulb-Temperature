package com.ryangrillo.service;

import com.ryangrillo.models.WeatherData;

import tk.plogitech.darksky.forecast.ForecastException;
import tk.plogitech.darksky.forecast.model.Forecast;

public interface APIServices {
	
	String[] getGoogleMapsAPI(String zipCode);

	Forecast getWeatherFromDarkSky(String[] latLonArray) throws ForecastException;
}
