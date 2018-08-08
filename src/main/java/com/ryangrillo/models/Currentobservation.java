package com.ryangrillo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currentobservation {

	private String id;

	private String name;

	private String elev;

	private String latitude;

	private String longitude;

	@JsonProperty(value = "Date")
	private String date;

	@JsonProperty(value = "Temp")
	private String temp;

	@JsonProperty(value = "Dewp")
	private String dewp;

	@JsonProperty(value = "Relh")
	private String relh;

	@JsonProperty(value = "Winds")
	private String winds;

	@JsonProperty(value = "Windd")
	private String windd;

	@JsonProperty(value = "Gust")
	private String gust;

	@JsonProperty(value = "Weather")
	private String weather;

	@JsonProperty(value = "WeatherImage")
	private String weatherimage;

	@JsonProperty(value = "Visibility")
	private String visibility;

	@JsonProperty(value = "Altimeter")
	private String altimeter;

	@JsonProperty(value = "SLP")
	private String sLP;

	private String timezone;

	private String state;

	@JsonProperty(value = "WindChill")
	private String windChill;

	public Currentobservation() {
	}

	public Currentobservation(String id, String name, String elev, String latitude, String longitude, String date,
			String temp, String dewp, String relh, String winds, String windd, String gust, String weather,
			String weatherimage, String visibility, String altimeter, String sLP, String timezone, String state,
			String windChill) {
		super();
		this.id = id;
		this.name = name;
		this.elev = elev;
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.temp = temp;
		this.dewp = dewp;
		this.relh = relh;
		this.winds = winds;
		this.windd = windd;
		this.gust = gust;
		this.weather = weather;
		this.weatherimage = weatherimage;
		this.visibility = visibility;
		this.altimeter = altimeter;
		this.sLP = sLP;
		this.timezone = timezone;
		this.state = state;
		this.windChill = windChill;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getElev() {
		return elev;
	}

	public void setElev(String elev) {
		this.elev = elev;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getDewp() {
		return dewp;
	}

	public void setDewp(String dewp) {
		this.dewp = dewp;
	}

	public String getRelh() {
		return relh;
	}

	public void setRelh(String relh) {
		this.relh = relh;
	}

	public String getWinds() {
		return winds;
	}

	public void setWinds(String winds) {
		this.winds = winds;
	}

	public String getWindd() {
		return windd;
	}

	public void setWindd(String windd) {
		this.windd = windd;
	}

	public String getGust() {
		return gust;
	}

	public void setGust(String gust) {
		this.gust = gust;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getWeatherimage() {
		return weatherimage;
	}

	public void setWeatherimage(String weatherimage) {
		this.weatherimage = weatherimage;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getAltimeter() {
		return altimeter;
	}

	public void setAltimeter(String altimeter) {
		this.altimeter = altimeter;
	}

	public String getsLP() {
		return sLP;
	}

	public void setsLP(String sLP) {
		this.sLP = sLP;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWindChill() {
		return windChill;
	}

	public void setWindChill(String windChill) {
		this.windChill = windChill;
	}

	@Override
	public String toString() {
		return "Currentobservation [id=" + id + ", name=" + name + ", elev=" + elev + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", date=" + date + ", temp=" + temp + ", dewp=" + dewp + ", relh=" + relh
				+ ", winds=" + winds + ", windd=" + windd + ", gust=" + gust + ", weather=" + weather
				+ ", weatherimage=" + weatherimage + ", visibility=" + visibility + ", altimeter=" + altimeter
				+ ", sLP=" + sLP + ", timezone=" + timezone + ", state=" + state + ", windChill=" + windChill + "]";
	}

}