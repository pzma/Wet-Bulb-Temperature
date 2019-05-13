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
	public WeatherData getWeatherDataAPI(String[] latLong) {
		Map<String, String> queryParam = new HashMap<>();
		queryParam.put(Constants.LATITUDE, latLong[0]);
		queryParam.put(Constants.LONGITUDE, latLong[1]);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(Constants.WEATHER_API_URL, WeatherData.class, queryParam);
		
	}
}
