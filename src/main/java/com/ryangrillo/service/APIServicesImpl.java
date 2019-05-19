package com.ryangrillo.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.ryangrillo.constants.Constants;
import com.ryangrillo.utils.GoogleMapsApi;

import tk.plogitech.darksky.api.jackson.DarkSkyJacksonClient;
import tk.plogitech.darksky.forecast.APIKey;
import tk.plogitech.darksky.forecast.ForecastException;
import tk.plogitech.darksky.forecast.ForecastRequest;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder.Language;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder.Units;
import tk.plogitech.darksky.forecast.GeoCoordinates;
import tk.plogitech.darksky.forecast.model.Forecast;
import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;

@Service
public class APIServicesImpl implements APIServices {

	@Override
	public String[] getGoogleMapsAPIUsingZip(String postalCode) throws ApiException, InterruptedException, IOException {
		GeoApiContext context = new GeoApiContext.Builder().apiKey(System.getenv(Constants.GOOGLE_MAPS_API_KEY)).build();
		GeocodingResult[] results = GeocodingApi.geocode(context, postalCode).await();
		return new String[] {String.valueOf(results[0].geometry.location.lat),
				String.valueOf(results[0].geometry.location.lng), results[0].formattedAddress };
	}
	
	@Override
	public String[] getGoogleMapsApiUsingLatLon(String latLon) throws ApiException, InterruptedException, IOException {
		String[] latlon = GoogleMapsApi.convertLatLonStringToArray(latLon);
		GeoApiContext context = new GeoApiContext.Builder().apiKey(System.getenv(Constants.GOOGLE_MAPS_API_KEY)).build();
		GeocodingResult[] results = GeocodingApi.reverseGeocode(context, new LatLng(Double.parseDouble(latlon[0]), Double.parseDouble(latlon[1]))).await();
		return new String[] {String.valueOf(results[0].geometry.location.lat),
				String.valueOf(results[0].geometry.location.lng), GoogleMapsApi.removeStreetAddress(results[2].formattedAddress)}; 
	}

	@Override
	public Forecast getWeatherFromDarkSky(String[] latLonArray) throws ForecastException {
		ForecastRequest request = new ForecastRequestBuilder()
				.key(new APIKey(System.getenv(Constants.DARK_SKY_API_KEY))).language(Language.en).units(Units.auto)
				.location(new GeoCoordinates(new Longitude(Double.parseDouble(latLonArray[1])),
						new Latitude(Double.parseDouble(latLonArray[0]))))
				.build();
		DarkSkyJacksonClient client = new DarkSkyJacksonClient();
		return client.forecast(request);

	}
}
