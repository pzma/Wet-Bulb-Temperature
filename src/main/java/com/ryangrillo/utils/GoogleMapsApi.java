package com.ryangrillo.utils;

public class GoogleMapsApi {
	
	private GoogleMapsApi() {}
	
	public static String[] convertLatLonStringToArray(String latlon) {
		return latlon.split(",");	
	}
	
	public static String removeStreetAddress(String s) {
		return s.substring(s.indexOf(',')+1).substring(1);
	}

}
