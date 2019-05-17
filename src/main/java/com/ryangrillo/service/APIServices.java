package com.ryangrillo.service;

import java.io.IOException;

import com.google.maps.errors.ApiException;
import tk.plogitech.darksky.forecast.ForecastException;
import tk.plogitech.darksky.forecast.model.Forecast;

public interface APIServices {
	
	String[] getGoogleMapsAPI(String zipCode) throws ApiException, InterruptedException, IOException;

	Forecast getWeatherFromDarkSky(String[] latLonArray) throws ForecastException;
}
