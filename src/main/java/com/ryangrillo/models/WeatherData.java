package com.ryangrillo.models;

public class WeatherData {

	private String operationalMode;

	private String srsName;

	private String creationDate;

	private String creationDateLocal;

	private String productionCenter;

	private String credit;

	private String moreInformation;

	private Location location;

	private Time time;

	private Data data;

	private Currentobservation currentobservation;

	public WeatherData() {
	}

	public WeatherData(String operationalMode, String srsName, String creationDate, String creationDateLocal,
			String productionCenter, String credit, String moreInformation, Location location, Time time, Data data,
			Currentobservation currentobservation) {
		super();
		this.operationalMode = operationalMode;
		this.srsName = srsName;
		this.creationDate = creationDate;
		this.creationDateLocal = creationDateLocal;
		this.productionCenter = productionCenter;
		this.credit = credit;
		this.moreInformation = moreInformation;
		this.location = location;
		this.time = time;
		this.data = data;
		this.currentobservation = currentobservation;
	}

	public String getOperationalMode() {
		return operationalMode;
	}

	public void setOperationalMode(String operationalMode) {
		this.operationalMode = operationalMode;
	}

	public String getSrsName() {
		return srsName;
	}

	public void setSrsName(String srsName) {
		this.srsName = srsName;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreationDateLocal() {
		return creationDateLocal;
	}

	public void setCreationDateLocal(String creationDateLocal) {
		this.creationDateLocal = creationDateLocal;
	}

	public String getProductionCenter() {
		return productionCenter;
	}

	public void setProductionCenter(String productionCenter) {
		this.productionCenter = productionCenter;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Currentobservation getCurrentobservation() {
		return currentobservation;
	}

	public void setCurrentobservation(Currentobservation currentobservation) {
		this.currentobservation = currentobservation;
	}

	@Override
	public String toString() {
		return "WeatherData [operationalMode=" + operationalMode + ", srsName=" + srsName + ", creationDate="
				+ creationDate + ", creationDateLocal=" + creationDateLocal + ", productionCenter=" + productionCenter
				+ ", credit=" + credit + ", moreInformation=" + moreInformation + "]";
	}

}
