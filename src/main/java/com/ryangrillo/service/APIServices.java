package com.ryangrillo.service;

import java.io.IOException;

import com.google.maps.errors.ApiException;
import tk.plogitech.darksky.forecast.ForecastException;
import tk.plogitech.darksky.forecast.model.Forecast;

public interface APIServices {
	
	Forecast getWeatherFromDarkSky(String[] latLonArray) throws ForecastException;

	String[] getGoogleMapsAPIUsingZip(String postalCode) throws ApiException, InterruptedException, IOException;

	String[] getGoogleMapsApiUsingLatLon(String latLon) throws ApiException, InterruptedException, IOException;
}
