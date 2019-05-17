package com.ryangrillo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ryangrillo.constants.Constants;
import com.ryangrillo.models.GoogleAPIData;
import com.ryangrillo.models.WeatherData;
import com.ryangrillo.utils.GoogleMapsApi;

import tk.plogitech.darksky.api.jackson.DarkSkyJacksonClient;
import tk.plogitech.darksky.forecast.APIKey;
import tk.plogitech.darksky.forecast.DarkSkyClient;
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
public class APIServicesImpl implements APIServices{

	@Override
	public String[] getGoogleMapsAPI(String postalCode) {
		Map<String, String> queryParam = new HashMap<>();
		queryParam.put(Constants.POSTAL_CODE, postalCode);
		RestTemplate restTemplate = new RestTemplate();
		GoogleAPIData googleAPIData = restTemplate.getForObject(Constants.GOOGLE_MAP_API_URL, GoogleAPIData.class, queryParam);
		return new String[] {GoogleMapsApi.getLatitude(googleAPIData), GoogleMapsApi.getLongitude(googleAPIData)};
		
	}
	
	@Override
	public Forecast getWeatherFromDarkSky(String[] latLonArray) throws ForecastException {
		ForecastRequest request = new ForecastRequestBuilder()
		        .key(new APIKey(System.getenv(Constants.DARK_SKY_API_KEY))).language(Language.en).units(Units.auto)
		        .location(new GeoCoordinates(new Longitude(Double.parseDouble(latLonArray[1])), new Latitude(Double.parseDouble(latLonArray[0])))).build();
		DarkSkyJacksonClient client = new DarkSkyJacksonClient();
	    return client.forecast(request);
	 
	}
}
