package com.ryangrillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryangrillo.helpers.WetBulbTempHelper;
import com.ryangrillo.models.LocationObject;
import com.ryangrillo.models.WeatherData;
import com.ryangrillo.models.WeatherObject;
import com.ryangrillo.models.WetBulbOutputVO;
import com.ryangrillo.service.APIServices;

@RestController
@RequestMapping(path = "/wetbulb")
public class Controller {
	
	@Autowired
	APIServices aPIServices;
	
	@Autowired
	WetBulbTempHelper wetBulbTempHelper;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/town/{zip}")
	public WetBulbOutputVO getWebBulbTemp(@PathVariable("zip") String zipCode) {
		String[] latLong = aPIServices.getGoogleMapsAPI(zipCode);
		WeatherData weatherData = aPIServices.getWeatherDataAPI(latLong);
		weatherData.getCurrentobservation().getRelh();
		String[] results = wetBulbTempHelper.calculateWetBulb(weatherData, latLong);
		return new WetBulbOutputVO(new LocationObject(latLong, weatherData.getLocation().getAreaDescription()), 
				new WeatherObject(results[0], results[1], weatherData.getCurrentobservation().getRelh()));
	}

}