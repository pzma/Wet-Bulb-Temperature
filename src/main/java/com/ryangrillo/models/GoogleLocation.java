package com.ryangrillo.models;

public class GoogleLocation {

	private Float lat;

	private Float lng;

	public GoogleLocation() {
	}

	public GoogleLocation(Float lat, Float lng) {
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
		return "GoogleLocation [lat=" + lat + ", lng=" + lng + "]";
	}
}