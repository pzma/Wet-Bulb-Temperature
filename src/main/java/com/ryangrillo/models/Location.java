package com.ryangrillo.models;

public class Location {

	private String region;

	private String latitude;

	private String longitude;

	private String elevation;

	private String wfo;

	private String timezone;

	private String areaDescription;

	private String radar;

	private String zone;

	private String county;

	private String firezone;

	private String metar;

	public Location() {
	}

	public Location(String region, String latitude, String longitude, String elevation, String wfo, String timezone,
			String areaDescription, String radar, String zone, String county, String firezone, String metar) {
		super();
		this.region = region;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.wfo = wfo;
		this.timezone = timezone;
		this.areaDescription = areaDescription;
		this.radar = radar;
		this.zone = zone;
		this.county = county;
		this.firezone = firezone;
		this.metar = metar;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public String getWfo() {
		return wfo;
	}

	public void setWfo(String wfo) {
		this.wfo = wfo;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getAreaDescription() {
		return areaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

	public String getRadar() {
		return radar;
	}

	public void setRadar(String radar) {
		this.radar = radar;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getFirezone() {
		return firezone;
	}

	public void setFirezone(String firezone) {
		this.firezone = firezone;
	}

	public String getMetar() {
		return metar;
	}

	public void setMetar(String metar) {
		this.metar = metar;
	}

	@Override
	public String toString() {
		return "Location [region=" + region + ", latitude=" + latitude + ", longitude=" + longitude + ", elevation="
				+ elevation + ", wfo=" + wfo + ", timezone=" + timezone + ", areaDescription=" + areaDescription
				+ ", radar=" + radar + ", zone=" + zone + ", county=" + county + ", firezone=" + firezone + ", metar="
				+ metar + "]";
	}

}