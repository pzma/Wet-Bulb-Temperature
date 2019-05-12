package com.ryangrillo.utils;

import java.time.Year;

public class MathCalculations {
		
	public static void main(String[] args) {
		double fa = julian(2019, 5, 10) / 365.0 * 2.0 * Math.PI;
		System.out.println("fa: " + fa);
		System.out.println(MathCalculations.getdVar(fa));
		System.out.println(getdVar(fa) * 0.1367e4);
		
	}

	public static final double RADEG = 180.0/Math.PI; 
	public static final double DEGRAD = Math.PI/180.0;
	public static final double INV360 = 1.0/360.0;

	public static double getWetBulbTemp(double tg, double nwb, double T) {
		return 0.2 * tg + 0.7 * nwb + 0.1 * T;
	}
	
	public static double getSinD(double x) {
		return Math.sin(x * DEGRAD);
	}
	public static double getCosD(double x) {
		return Math.cos(x * DEGRAD);
	}
	public static double getTanD(double x) {
		return Math.tan(x * DEGRAD);
	}
	
	public static double aTanD(double x) {
		return Math.atan(x) * RADEG;
	}
	public static double aSinD(double x) {
		return Math.asin(x) * RADEG;
	}
	public static double aCosD(double x) {
		return Math.acos(x) * RADEG;
	}

	public static double aTan2D(double y, double x) {
		return Math.atan2(y, x) * RADEG;
	}
	
	public static double getnwb(double Tw, double ir, double wms) {
		double nwb = Tw + (0.0021 * ir) - (0.43 * wms) + 1.93;
		if(nwb < Tw) {
			nwb = Tw;
		}
		if(nwb < 50) {
			nwb = 50;
		}
		if (nwb > 85) {
			nwb = 85;
		}
		return nwb;
	}

	public static double getTw(double Twc) {
		return (1.8 * Twc) + 32.0;
	}


	public static int julian(int year, int month, int day) {
		int[] lMonth;
		if (isLeapYear(year)) {
			lMonth = new int[] { 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366 };
		} else {
			lMonth = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
		}
		return lMonth[month - 1] + day;
	}

	public static boolean isLeapYear(int year) {
		return Year.of(year).isLeap();
	}

	////////////////////////////////////////////////////////////////////////////////////
	public static double getc(double wspd) {
		double h = 0.315;
		return (Math.pow(wspd, 0.58) * h) / (5.3865 * Math.pow(10.0, -8.0));
	}

	public static double gett(double iTemp) {
		return ((iTemp - 32.0) * 5.0 / 9.0);
	}

	public static double getwspd(double spd) {
		return spd * 1609.0;
	}

	public static double getTwc(double s2, double t, double fp, double s1, double td) {
		return (s2 == 0) ? t : (t * fp + (td * s1 / s2)) / (fp + s1 / s2);
	}

	public static double getfp(double p) {
		double f = 0.0006355;
		return f * p;
	}

	public static double gettd(double iDwpt) {
		return (iDwpt - 32.0) * 5.0 / 9.0;
	}

	public static double gets1(double es, double ed) {
		return es - ed;
	}

	public static double gets2(double t, double td) {
		return t - td;
	}

	public static double getp(double presMB) {
		return presMB;
	}

	public static double getiDwpt(double dwpt) {
		return dwpt;
	}

	public static double getes(double t) {
		return 6.11 * Math.pow(10.0, ((t * 7.5) / (t + 237.3)));
	}

	public static double getir(double maxFlux) {
		return maxFlux;
	}

	public static double[] getEquationOfTime(double latitude, int month, int year, int day) {
		int nJulianDate = julian(year, month, day);
		double fDivide = (isLeapYear(year)) ? 366.0 : 365.0;
		double fA = nJulianDate / fDivide * 2 * Math.PI;
		double fR0r = getdVar(fA) * 0.1367e4;
		double fRdecl = 0.412 * Math.cos((nJulianDate + 10.0) * 2.0 * Math.PI / fDivide - Math.PI);
		double fDecLsc1 = getSinD(latitude) * Math.sin(fRdecl);
		double fDecLsc2 = getCosD(latitude) * Math.cos(fRdecl);
		double fEot = ((0.002733 -7.343*Math.sin(fA)+ .5519*Math.cos(fA) 
				- 9.47*Math.sin(2.0*fA) - 3.02*Math.cos(2.0*fA) 
				- 0.3289*Math.sin(3.*fA) -0.07581*Math.cos(3.0*fA) 
				-0.1935*Math.sin(4.0*fA) -0.1245*Math.cos(4.0*fA))/ 60.0) * 15.0 * DEGRAD;
		return new double[] {fEot, fR0r, fDecLsc1, fDecLsc2};
		
	}
	
	public static double getMaxSolarFlux(double latitude, int year, int month, int day) {
		double edat[] = getEquationOfTime(latitude, month, year, day);
		double fsf = (edat[2] + edat[3]) * edat[1];
		double fSFT;
		double fCoeff;
		
		if (fsf < 0.0) {
			fCoeff = 0.0;
		} else {
			fCoeff = -1.56e-12*Math.pow(fsf,4) + 5.972e-9*Math.pow(fsf,3) - 8.364e-6*Math.pow(fsf,2) + 5.183e-3*fsf - 0.435;
		}
		
		fSFT = fsf * fCoeff;
		if(fSFT < 0.0) {
			fSFT = 0.0;
		}
		
		return fSFT;
		

		
	}
	

	public static double getdVar(double dAlf) {

		return 1.0 / ((1.0 - 9.464e-4 * Math.sin(dAlf) - 0.01671 * Math.cos(dAlf) - +1.489e-4 * Math.cos(2.0 * dAlf)
				- 2.917e-5 * Math.sin(3.0 * dAlf) - +3.438e-4 * Math.pow(Math.cos(4.0 * dAlf), 2.0)));

	}

	public static double geted(double td) {
		return 6.11 * Math.pow(10.0, ((td * 7.5) / (td + 237.3)));
	}

	public static double getspd(double iWspd) {
		return (iWspd < 4) ? 4 : iWspd;
	}

	public static double gettg(double maxFluxb, double c, double t) {
		return ((maxFluxb + c * t + 7680000.0) / (c + 256000.0)) * 1.8 + 32.0;
	}

	public static double getMaxFluxb(double maxFlux, double b1, double b2) {
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
	
	public static double getEa(double a, double p, double b) {
		return a * (1.0007 + 0.00000346 * p) * (6.112 * b);
	}
	
	public static void geta(double td, double t) {
		Math.exp((17.67 * (td - t)) / (td + 243.5));
	}
	
	public static double getb(double t) {
		return Math.exp((17.502 * t) / (240.97 + t));
	}
	
	public static double getEa2(double ea) {
		return Math.pow(ea * 0.575, 1.0/7.0);
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
		return (tempLabel.equalsIgnoreCase("High")) ? 0 : 1;
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
