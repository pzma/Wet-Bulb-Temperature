package com.ryangrillo.constants;

public class Constants {
	
	private Constants() {}	
	
	//API URLs
	public static final String GOOGLE_MAP_API_URL = System.getenv("googleMapsUrl") + System.getenv("key");
	
	//key
	public static final String DARK_SKY_API_KEY= "darkSkyKey";
	//QueryParams
	public static final String LATITUDE = "textField1";
	public static final String LONGITUDE = "textField2";
	public static final String POSTAL_CODE = "postal_code";
	
}
