package com.ryangrillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryangrillo.models.GoogleAPIData;
import com.ryangrillo.models.WeatherData;
import com.ryangrillo.service.APIServices;

@RestController
@RequestMapping(path = "/wetbulb")
public class Controller {
	
	@Autowired
	APIServices aPIServices;


	@GetMapping("/town")
	public WeatherData getWebBulbTemp(@RequestParam(value = "zip", required = true) String zipCode) {
		GoogleAPIData googleAPIData = aPIServices.getGoogleMapsAPI(zipCode);
		
		String latitude = googleAPIData.getResults().get(0).getGeometry().getLocation().getLat().toString() ;
		String longitude = googleAPIData.getResults().get(0).getGeometry().getLocation().getLng().toString();
		
		return aPIServices.getWeatherDataAPI(latitude, longitude);
		
	}
	    
}
