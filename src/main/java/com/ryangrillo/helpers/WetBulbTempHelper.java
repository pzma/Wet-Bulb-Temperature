package com.ryangrillo.helpers;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ryangrillo.models.WeatherData;
import com.ryangrillo.utils.MathCalculations;

@Component
public class WetBulbTempHelper {

	public String[] calculateWetBulb(WeatherData weatherData, String[] latitudeLongitudeArray) {
		LocalDateTime calendar = LocalDateTime.now();
		double maxFlux = MathCalculations.getMaxSolarFlux(Float.parseFloat(latitudeLongitudeArray[0]), calendar.getYear(),
				calendar.getMonth().getValue(), calendar.getDayOfMonth());
		String tempLabel = weatherData.getTime().getTempLabel().get(0);
		int maxPD = MathCalculations.getMaxPD(tempLabel);
		List<String> weather = weatherData.getData().getWeather();
		String sky = MathCalculations.getsky(weather, maxPD);
		double iCloud = MathCalculations.getiCloud(sky);
		double fdb = MathCalculations.getfdb(iCloud);
		double fdif = MathCalculations.getfdif(fdb);
		double b1 = MathCalculations.getb1(fdb, fdif);
		double dwpt = Double.parseDouble(weatherData.getCurrentobservation().getDewp());
		double iDwpt = MathCalculations.getiDwpt(dwpt);
		double td = MathCalculations.gettd(iDwpt);
		double iTemp = Double.parseDouble(weatherData.getData().getTemperature().get(maxPD));
		double t = MathCalculations.gett(iTemp);
		double a = MathCalculations.geta(td, t);
		double presMB = Double.parseDouble(weatherData.getCurrentobservation().getsLP());
		double p = MathCalculations.getp(presMB);
		double b = MathCalculations.getb(t);
		double ea = MathCalculations.getEa(a, p, b);
		double ea2 = MathCalculations.getEa2(ea);
		double b2 = MathCalculations.getb2(ea2, t);
		double maxFluxB = MathCalculations.getMaxFluxb(maxFlux, b1, b2);
		double iWspd = Double.parseDouble(weatherData.getCurrentobservation().getWinds());
		double spd = MathCalculations.getspd(iWspd);
		double wspd = MathCalculations.getwspd(spd);
		double c = MathCalculations.getc(wspd);
		double tg = MathCalculations.gettg(maxFluxB, c, t);
		double s2 = MathCalculations.gets2(t, td);
		double fp = MathCalculations.getfp(p);
		double es = MathCalculations.getes(t);
		double ed = MathCalculations.geted(td);
		double s1 = MathCalculations.gets1(es, ed);
		double Twc = MathCalculations.getTwc(s2, t, fp, s1, td);
		double Tw = MathCalculations.getTw(Twc);
		double ir = MathCalculations.getir(maxFlux);
		double wms = MathCalculations.getWms(iWspd);
		double nwb = MathCalculations.getnwb(Tw, ir, wms);
		double wetBulbTemp = MathCalculations.getWetBulbTemp(tg, nwb, iTemp);
		DecimalFormat df = new DecimalFormat("###");
		df.format(Math.round(wetBulbTemp));
		return new String[] {df.format(Math.round(wetBulbTemp)), df.format(Math.round(iTemp))};

	}
}
