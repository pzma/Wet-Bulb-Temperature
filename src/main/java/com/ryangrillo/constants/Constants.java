package com.ryangrillo.constants;

public class Constants {
	
	private Constants() {}
	
	//Google Maps API key
	public static final String KEY = "AIzaSyAIjdHylhleat9mqMuWW4f8qeYwu9NaWzU"; 	
	
	//API URLs
	public static final String WEATHER_API_URL = "https://forecast.weather.gov/MapClick.php?w0=t&w1=td&w2=hi&w3=sfcwind&w3u=0&w4=sky&w5=pop&w6=rh&w7=rain&w8=thunder&pqpfhr=6&AheadHour=0&Submit=Submit&FcstType=json&textField1={textField1}&textField2={textField2}&site=all&unit=0&dd=&bw=";
	public static final String GOOGLE_MAP_API_URL = "https://maps.googleapis.com/maps/api/geocode/json?components=postal_code:{postal_code}&key=" + KEY;
	
	//QueryParams
	public static final String LATITUDE = "textField1";
	public static final String LONGITUDE = "textField2";
	public static final String POSTAL_CODE = "postal_code";
	
}
