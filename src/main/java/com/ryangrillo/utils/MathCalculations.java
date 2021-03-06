package com.ryangrillo.utils;

import java.time.Year;
import java.util.List;

public class MathCalculations {

	private MathCalculations() {
	}

	public static final double RADEG = 180.0 / Math.PI;
	public static final double DEGRAD = Math.PI / 180.0;
	public static final double INV360 = 1.0 / 360.0;

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

	public static double getWms(double spd) {
		return spd * 0.4474;
	}

	public static double getnwb(double Tw, double ir, double wms) {
		double nwb = Tw + (0.0021 * ir) - (0.43 * wms) + 1.93;
		if (nwb < Tw) {
			nwb = Tw;
		}
		if (nwb < 50) {
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

	public static double getp(String slp) {
		double parsedSlp;
		try {
			parsedSlp = Double.parseDouble(slp);
			if (parsedSlp >= 26.0 && parsedSlp <= 34.0) {
				return parsedSlp * 33.8639;
			} else {
				return 1000.0;
			}
		} catch (NumberFormatException e) {
			return 1000.00;
		}

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
		double fEot = ((0.002733 - 7.343 * Math.sin(fA) + .5519 * Math.cos(fA) - 9.47 * Math.sin(2.0 * fA)
				- 3.02 * Math.cos(2.0 * fA) - 0.3289 * Math.sin(3. * fA) - 0.07581 * Math.cos(3.0 * fA)
				- 0.1935 * Math.sin(4.0 * fA) - 0.1245 * Math.cos(4.0 * fA)) / 60.0) * 15.0 * DEGRAD;
		return new double[] { fEot, fR0r, fDecLsc1, fDecLsc2 };

	}

	public static double getMaxSolarFlux(double latitude, int year, int month, int day) {
		double edat[] = getEquationOfTime(latitude, month, year, day);
		double fsf = (edat[2] + edat[3]) * edat[1];
		double fSFT;
		double fCoeff;

		if (fsf < 0.0) {
			fCoeff = 0.0;
		} else {
			fCoeff = -1.56e-12 * Math.pow(fsf, 4) + 5.972e-9 * Math.pow(fsf, 3) - 8.364e-6 * Math.pow(fsf, 2)
					+ 5.183e-3 * fsf - 0.435;
		}

		fSFT = fsf * fCoeff;
		if (fSFT < 0.0) {
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

	public static double geta(double td, double t) {
		return Math.exp((17.67 * (td - t)) / (td + 243.5));
	}

	public static double getb(double t) {
		return Math.exp((17.502 * t) / (240.97 + t));
	}

	public static double getEa2(double ea) {
		return Math.pow(ea * 0.575, 1.0 / 7.0);
	}

	public static double getfdif(double fdb) {
		return 1.0 - fdb;
	}

	public static double getfdb(double iCloud) {
		return iCloud / 100.0;
	}

	public static double getiCloud(Double sky) { 
		return sky * 100;
	}

	public static int getMaxPD(String tempLabel) {
		return (tempLabel.equalsIgnoreCase("High")) ? 0 : 1;
	}

}
