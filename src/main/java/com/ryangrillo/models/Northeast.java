package com.ryangrillo.models;

public class Northeast {

	private Float lat;

	private Float lng;

	public Northeast() {
	}

	public Northeast(Float lat, Float lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLng() {
		return lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Northeast [lat=" + lat + ", lng=" + lng + "]";
	}

}