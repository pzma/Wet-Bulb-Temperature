package com.ryangrillo.utils;

public class WeatherAPI {

		public static String convertDoubleToString(double humidity) {
			return String.valueOf((int)(humidity * 100));
		}
}
