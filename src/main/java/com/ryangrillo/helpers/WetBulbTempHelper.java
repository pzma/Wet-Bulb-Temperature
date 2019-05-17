package com.ryangrillo.helpers;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ryangrillo.models.WeatherData;
import com.ryangrillo.utils.MathCalculations;

import tk.plogitech.darksky.forecast.model.Forecast;

@Component
public class WetBulbTempHelper {

	public String[] calculateWetBulb(WeatherData weatherData, String[] latitudeLongitudeArray, Forecast forecast) {
		LocalDateTime calendar = LocalDateTime.now();
		double maxFlux = MathCalculations.getMaxSolarFlux(Float.parseFloat(latitudeLongitudeArray[0]), calendar.getYear(),
				calendar.getMonth().getValue(), calendar.getDayOfMonth());
		double iCloud = MathCalculations.getiCloud(forecast.getCurrently().getCloudCover());
		double fdb = MathCalculations.getfdb(iCloud);
		double fdif = MathCalculations.getfdif(fdb);
		double b1 = MathCalculations.getb1(fdb, fdif);
		double iDwpt = forecast.getCurrently().getDewPoint();
		double td = MathCalculations.gettd(iDwpt);
		double t = MathCalculations.gett(forecast.getCurrently().getTemperature());
		double a = MathCalculations.geta(td, t);
		double b = MathCalculations.getb(t);
		double ea = MathCalculations.getEa(a, forecast.getCurrently().getPressure(), b);
		double ea2 = MathCalculations.getEa2(ea);
		double b2 = MathCalculations.getb2(ea2, t);
		double maxFluxB = MathCalculations.getMaxFluxb(maxFlux, b1, b2);
		double wspd = MathCalculations.getwspd(forecast.getCurrently().getWindSpeed());
		double c = MathCalculations.getc(wspd);
		double tg = MathCalculations.gettg(maxFluxB, c, t);
		double s2 = MathCalculations.gets2(t, td);
		double fp = MathCalculations.getfp(forecast.getCurrently().getPressure());
		double es = MathCalculations.getes(t);
		double ed = MathCalculations.geted(td);
		double s1 = MathCalculations.gets1(es, ed);
		double Twc = MathCalculations.getTwc(s2, t, fp, s1, td);
		double Tw = MathCalculations.getTw(Twc);
		double ir = MathCalculations.getir(maxFlux);
		double wms = MathCalculations.getWms(forecast.getCurrently().getWindSpeed());
		double nwb = MathCalculations.getnwb(Tw, ir, wms);
		double wetBulbTemp = MathCalculations.getWetBulbTemp(tg, nwb, forecast.getCurrently().getTemperature());
		DecimalFormat df = new DecimalFormat("###");
		df.format(Math.round(wetBulbTemp));
		return new String[] {df.format(Math.round(wetBulbTemp)), df.format(Math.round(forecast.getCurrently().getTemperature()))};

	}
}
