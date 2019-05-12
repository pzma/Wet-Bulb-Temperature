package com.ryangrillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryangrillo.models.GoogleAPIData;
import com.ryangrillo.models.WeatherData;
import com.ryangrillo.service.APIServices;
import com.ryangrillo.utils.MathCalculations;

@RestController
@RequestMapping(path = "/wetbulb")
public class Controller {
	
	@Autowired
	APIServices aPIServices;


	@GetMapping("/town/{zip}")
	public WeatherData getWebBulbTemp(@PathVariable("zip") String zipCode) {
		GoogleAPIData googleAPIData = aPIServices.getGoogleMapsAPI(zipCode);
		WeatherData weatherData = aPIServices.getWeatherDataAPI(googleAPIData);
		return aPIServices.getWeatherDataAPI(googleAPIData);
	}
	    
}
