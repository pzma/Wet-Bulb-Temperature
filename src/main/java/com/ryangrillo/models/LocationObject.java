package com.ryangrillo.models;

public class LocationObject {
	
	private String latitude;
	
	private String longitude;
	
	private String description;

	public LocationObject(String latitude, String longitude, String description) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
	}
	
	

	public LocationObject(String[] latLong, String description) {
		super();
		this.latitude = latLong[0];
		this.longitude = latLong[1];
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
