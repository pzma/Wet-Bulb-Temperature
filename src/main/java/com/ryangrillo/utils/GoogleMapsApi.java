package com.ryangrillo.utils;

public class GoogleMapsApi {
	
	private GoogleMapsApi() {}
	
	public static String[] convertLatLonStringToArray(String latlon) {
		return latlon.split(",");	
	}

}
