package com.ryangrillo.constants;

public class Constants {
	
	private Constants() {}	
	
	//API URLs
	public static final String WEATHER_API_URL = System.getenv("weatherUrl");
	public static final String GOOGLE_MAP_API_URL = System.getenv("googleMapsUrl") + System.getenv("key");
	//QueryParams
	public static final String LATITUDE = "textField1";
	public static final String LONGITUDE = "textField2";
	public static final String POSTAL_CODE = "postal_code";
	
}
