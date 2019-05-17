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
	public WetBulbOutputVO getWebBulbTemp(@RequestParam(value = "zip", required = false) String zip, 
										  @RequestParam(value = "latlon", required = false) String latLon) throws ForecastException {

		String[] results;
		String[] latLongArr;
		Forecast weatherApi;
		if (latLon != null) {
			latLongArr = GoogleMapsApi.convertLatLonStringToArray(latLon);
		} else {
			latLongArr = aPIServices.getGoogleMapsAPI(zip);
		}
		weatherApi = aPIServices.getWeatherFromDarkSky(latLongArr);
		results = wetBulbTempHelper.calculateWetBulb(null, latLongArr, weatherApi);
		
		return new WetBulbOutputVO(new LocationObject(latLongArr, weatherApi.getTimezone()),
				new WeatherObject(results[0], results[1], WeatherAPI.convertDoubleToString(weatherApi.getCurrently().getHumidity()) ),
				new InformationSetter().setInformation(results[0]));
	}

}