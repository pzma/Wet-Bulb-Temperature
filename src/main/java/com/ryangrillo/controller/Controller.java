package com.ryangrillo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.errors.ApiException;
import com.ryangrillo.helpers.WetBulbTempHelper;
import com.ryangrillo.models.InformationObect;
import com.ryangrillo.models.LocationObject;
import com.ryangrillo.models.WeatherData;
import com.ryangrillo.models.WeatherObject;
import com.ryangrillo.models.WetBulbOutputVO;
import com.ryangrillo.service.APIServices;
import com.ryangrillo.utils.GoogleMapsApi;
import com.ryangrillo.utils.InformationSetter;
import com.ryangrillo.utils.WeatherAPI;

import tk.plogitech.darksky.forecast.ForecastException;
import tk.plogitech.darksky.forecast.model.Forecast;

@RestController
@RequestMapping(path = "/location")
public class Controller {

	@Autowired
	APIServices aPIServices;

	@Autowired
	WetBulbTempHelper wetBulbTempHelper;

	@CrossOrigin(origins = "*")
	@GetMapping
	public WetBulbOutputVO getWebBulbTemp(@RequestParam(value = "zip", required = true) String zip)
			throws ForecastException, ApiException, InterruptedException, IOException {

		String[] results;
		String[] latLongArr;
		Forecast weatherApi;
		
		latLongArr = aPIServices.getGoogleMapsAPI(zip);
		weatherApi = aPIServices.getWeatherFromDarkSky(latLongArr);
		results = wetBulbTempHelper.calculateWetBulb(latLongArr, weatherApi);
		return new WetBulbOutputVO(new LocationObject(latLongArr, latLongArr[2]),
				new WeatherObject(results[0], results[1], WeatherAPI.convertDoubleToString(weatherApi.getCurrently().getHumidity())),
				new InformationSetter().setInformation(results[0]));
	}

}