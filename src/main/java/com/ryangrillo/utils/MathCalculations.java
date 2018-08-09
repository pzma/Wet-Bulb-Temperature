package com.ryangrillo.utils;

public class MathCalculations {

	public static double getWetBulbTemp(double tg, double nwb, double T) {
		return 0.2 * tg + 0.7 * nwb + 0.1 * T;
	}

	public static double getc(double wspd) {
		double h = 0.315;
		return (Math.pow(wspd, 0.58) * h) / (5.3865 * Math.pow(10.0, -8.0)) ;
	}
	
	public static double gett(double iTemp) {
		return ((iTemp - 32.0) * 5.0 / 9.0 ) ;
		}
	
	public static double getwspd(double spd) {
		return spd * 1609.0;
	}
	
	public static double getnwb(double Tw, double ir, double wms) {
		return Tw + (0.0021 * ir) - (0.43 * wms) + 1.93;
	}
	
	public static double getTw(double Twc) {
		return (1.8 * Twc) + 32.0;
	}
	
	public static double getTwc(double s2, double t, double fp, double s1, double td) {
		return (s2 == 0) ? t : (t * fp + (td * s1 / s2)) / (fp + s1/s2);
	}
	
	public static double getfp(double p) {
		double f = 0.0006355;
		return f * p;
	}
	//left of here at gettd
	public static double gettd(double iDwpt) {
		return (iDwpt - 32.0) * 5.0/9.0;
	}
	
	public static double getspd(double iWspd) {
		return (iWspd < 4) ? 4 : iWspd;
	}
	
	public static double gettg(double b, double c, double t) {
		return ((b + c + t + 7680000.0) / (c + 256000.0)) * 1.8 + 32.0;
	}

	public static double getb(double maxFlux, double b1, double b2) {
		return maxFlux * b1 + b2;
	}

	public static double getb1(double fdb, double fdif) {
		double cosz = 0.707;
		double bc = (5.67 * Math.pow(10.0, -8.0));
		return fdb / (4.0 * cosz * bc) + (1.2 / bc) * fdif;
	}

	public static double getb2(double ea2, double t) {
		return ea2 * Math.pow(t, 4.0);
	}

	public static double getfdif(double fdb) {
		return 1.0 - fdb;
	}

	public static double getfdb(double iCloud) {
		return iCloud / 100.0;
	}

	public static double getiCloud(String sky) {
		double iCloud;
		if (sky.equalsIgnoreCase("Sunny")) {
			iCloud = 0.0;
		} else if (sky.equalsIgnoreCase("Hot") || sky.equalsIgnoreCase("Mostly Sunny")
				|| sky.equalsIgnoreCase("Partly Cloudy")) {
			iCloud = 20.0;
		} else if (sky.equalsIgnoreCase("Mostly Cloudy") || sky.equalsIgnoreCase("Partly Sunny")) {
			iCloud = 60.0;
		} else if (sky.equalsIgnoreCase("Cloudy")) {
			iCloud = 100.0;
		} else {
			iCloud = 50.0;
		}
		return iCloud;
	}
	
	public static String getsky(String[] weather, int maxPD) {
		return weather[maxPD];
		
	}
	
	public static int getMaxPD(String tempLabel) {
		return (tempLabel.equalsIgnoreCase("High")) ? 0 :  1;
	}

//	public static void calculateWetBulb(WeatherData weatherData) {
//		String tempLabel = weatherData.getTime().getTempLabel().get(0); // high or low
//		int maxPD = getMaxPD(tempLabel); // returns 0 or 1
//		String tempHighOrLow = weatherData.getData().getTemperature().get(maxPD); // returns actual temp high or low ie 64 or 85
//		int temp = getMaxTemp(tempHighOrLow);
//		
//	}
//	
//	public static int getMaxPD(String tempLabel) {//nosonar
//		int maxPD;
//		maxPD = (tempLabel.equalsIgnoreCase("High")) ? 0 :  1;
//		return maxPD;
//	}
//	
//	public static int getMaxTemp(String tempHighOrLow) {
//		int maxTemp = Integer.parseInt(tempHighOrLow);
//		int temp = 80;
//		if (maxTemp >= 40 && maxTemp <= 130) {
//			temp = maxTemp;
//		}
//		return temp;
//	}
//	
//	public static double calculateHeatIndex(int temp) {
//		double heatIndex = 0;
//		double tempCelsius;
//		double tempDewpointCelsius;
//		double relativeHumidity;
//		double a = -42.379;
//		double b = 2.04901523 * temp;
//		double c ;
//		double d;
//		double e;
//		double f;
//		double g;
//		double h;
//		double i;
//		if(temp < 80 ) {
//			heatIndex = temp;
//		} else {
//			
//			
//		}
//		return heatIndex;
//		
//	}

}
