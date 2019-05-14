package com.ryangrillo.models;

public class WetBulbOutputVO {

	private LocationObject location;

	private WeatherObject weather;

	private InformationObect information;
	

	public WetBulbOutputVO(LocationObject location, WeatherObject weather, InformationObect information) {
		super();
		this.location = location;
		this.weather = weather;
		this.information = information;
	}
	
	
	
	

	public WetBulbOutputVO(LocationObject location, WeatherObject weather) {
		super();
		this.location = location;
		this.weather = weather;
	}





	public InformationObect getInformation() {
		return information;
	}



	public void setInformation(InformationObect information) {
		this.information = information;
	}



	public LocationObject getLocation() {
		return location;
	}

	public void setLocation(LocationObject location) {
		this.location = location;
	}

	public WeatherObject getWeather() {
		return weather;
	}

	public void setWeather(WeatherObject weather) {
		this.weather = weather;
	}

}