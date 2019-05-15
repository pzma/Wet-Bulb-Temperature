package com.ryangrillo.utils;

import java.util.Locale.Category;

import com.ryangrillo.models.Heavy;
import com.ryangrillo.models.InformationObect;
import com.ryangrillo.models.Light;
import com.ryangrillo.models.Moderate;
import com.ryangrillo.models.Work;

public class InformationSetter {
	
		public static final String ONE_HALF = "1/2";
		public static final String THREE_FOURTHS = "3/4";
		public static final String ONE = "1";
		public static final String TEN = "10";
		public static final String TWENTY = "20";
		public static final String THIRTY = "30";
		public static final String FORTY = "40";
		public static final String FIFTY = "50";
		public static final String NONE = "none";
		public static final String LOW = "low";
		public static final String MODERATE = "moderate";
		public static final String HIGH = "high";
		public static final String EXTREME = "extreme";
		

		public InformationObect setInformation(String wetBulbTemp) {
			
			int wetBulbTmp = Integer.parseInt(wetBulbTemp);
			
			if (wetBulbTmp < 80) {
				Work work = new Work(new Light(FIFTY, TEN, ONE_HALF), 
						new Moderate(FORTY, TWENTY, THREE_FOURTHS, false), 
						new Heavy(THIRTY, THIRTY, THREE_FOURTHS, false));
				return new InformationObect(NONE, work);
			}
			
			if (wetBulbTmp >=80 && wetBulbTmp < 85) {
				Work work = new Work(new Light(FORTY, TWENTY, ONE_HALF), 
						new Moderate(THIRTY, THIRTY, THREE_FOURTHS, false), 
						new Heavy(TWENTY, FORTY, ONE, false));
				return new InformationObect(LOW, work);
			}
			if (wetBulbTmp >=85 && wetBulbTmp < 88) {
				Work work = new Work( new Light(THIRTY, THIRTY, THREE_FOURTHS), 
						new Moderate(TWENTY, FORTY, THREE_FOURTHS, false), 
						new Heavy(TEN, FIFTY, ONE, false));
				return new InformationObect(MODERATE, work);
			}
			if (wetBulbTmp >=88 && wetBulbTmp <= 90) {
					Work work = new Work(new Light(TWENTY, FORTY, THREE_FOURTHS), 
							new Moderate(TEN, FIFTY, THREE_FOURTHS, false), 
							new Heavy(null, null, ONE, true));
					return new InformationObect(HIGH, work);
			}
			if (wetBulbTmp > 90) {
				Work work = new Work( new Light(TEN, FIFTY, ONE), 
						new Moderate(TEN, FIFTY, THREE_FOURTHS, false), 
						new Heavy(null, null, ONE, true));
				return new InformationObect(EXTREME, work);
			}
			return null;
				
		}
}
