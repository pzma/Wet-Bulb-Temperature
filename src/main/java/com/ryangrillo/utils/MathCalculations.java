package com.ryangrillo.utils;

import com.ryangrillo.models.WeatherData;

public class MathCalculations {
	
	public static void calculateWetBulb(WeatherData weatherData) {
		String tempLabel = weatherData.getTime().getTempLabel().get(0); // high or low
		int maxPD = getMaxPD(tempLabel); // returns 0 or 1
		String tempHighOrLow = weatherData.getData().getTemperature().get(maxPD); // returns actual temp high or low ie 64 or 85
		int temp = getMaxTemp(tempHighOrLow);
		
	}
	
	public static int getMaxPD(String tempLabel) {
		int maxPD;
		if(tempLabel.equals("High")) {
			maxPD = 0;
		}
		else {
			maxPD = 1;
		}
		return maxPD;
	}
	
	public static int getMaxTemp(String tempHighOrLow) {
		int maxTemp = Integer.parseInt(tempHighOrLow);
		int temp = 80;
		if (maxTemp >= 40 && maxTemp <= 130) {
			temp = maxTemp;
		}
		return temp;
	}
	
	public static double calculateHeatIndex(int temp) {
		double heatIndex = 0;
		double tempCelsius;
		double tempDewpointCelsius;
		double relativeHumidity;
		double a = -42.379;
		double b = 2.04901523 * temp;
		double c ;
		double d;
		double e;
		double f;
		double g;
		double h;
		double i;
		if(temp < 80 ) {
			heatIndex = temp;
		} else {
			
			
		}
		return heatIndex;
		
	}
	
	
	
}
