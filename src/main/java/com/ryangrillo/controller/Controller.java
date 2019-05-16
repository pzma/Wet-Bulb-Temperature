package com.ryangrillo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryangrillo.helpers.WetBulbTempHelper;
import com.ryangrillo.models.InformationObect;
import com.ryangrillo.models.LocationObject;
import com.ryangrillo.models.WeatherData;
import com.ryangrillo.models.WeatherObject;
import com.ryangrillo.models.WetBulbOutputVO;
import com.ryangrillo.service.APIServices;
import com.ryangrillo.utils.GoogleMapsApi;
import com.ryangrillo.utils.InformationSetter;

@RestController
@RequestMapping(path = "/location")
public class Controller {

	@Autowired
	APIServices aPIServices;

	@Autowired
	WetBulbTempHelper wetBulbTempHelper;

	@CrossOrigin(origins = "*")
	@GetMapping
	public WetBulbOutputVO getWebBulbTemp(@RequestParam(value = "zip", required = false) String zip, 
										  @RequestParam(value = "latlon", required = false) String latLon) {

		String[] results;
		String[] latLongArr;
		WeatherData weatherData;
		if (latLon != null) {
			latLongArr = GoogleMapsApi.convertLatLonStringToArray(latLon);
			weatherData = aPIServices.getWeatherDataAPI(latLongArr);
			results = wetBulbTempHelper.calculateWetBulb(weatherData, latLongArr);
		} else {
			latLongArr = aPIServices.getGoogleMapsAPI(zip);
			weatherData = aPIServices.getWeatherDataAPI(latLongArr);
			results = wetBulbTempHelper.calculateWetBulb(weatherData, latLongArr);
		}
		return new WetBulbOutputVO(new LocationObject(latLongArr, weatherData.getLocation().getAreaDescription()),
				new WeatherObject(results[0], results[1], weatherData.getCurrentobservation().getRelh()),
				new InformationSetter().setInformation(results[0]));
	}

}