package com.ryangrillo.utils;

import com.ryangrillo.models.GoogleAPIData;

public class GoogleMapsApi {
	
	private GoogleMapsApi() {}
	 
	public static String getLatitude(GoogleAPIData googleApiData) {
		 return googleApiData.getResults().get(0).getGeometry().getLocation().getLat().toString();
	}
	
	public static String getLongitude(GoogleAPIData googleAPIData) {
		return googleAPIData.getResults().get(0).getGeometry().getLocation().getLng().toString();
	}
	
	public static String[] convertLatLonStringToArray(String latlon) {
		return latlon.split(",");	
	}

}
