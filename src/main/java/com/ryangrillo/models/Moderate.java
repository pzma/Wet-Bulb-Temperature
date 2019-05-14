package com.ryangrillo.models;

public class Moderate {
	
	private String active;
	
	private String rest;
	
	private String water;
	
	private String alert;

	public Moderate(String active, String rest, String water, String alert) {
		super();
		this.active = active;
		this.rest = rest;
		this.water = water;
		this.alert = alert;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}
}
