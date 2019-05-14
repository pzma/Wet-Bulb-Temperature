package com.ryangrillo.models;

public class Moderate {
	
	private String active;
	
	private String rest;
	
	private String water;
	
	private boolean avoid;

	public Moderate(String active, String rest, String water, boolean avoid) {
		super();
		this.active = active;
		this.rest = rest;
		this.water = water;
		this.avoid = avoid;
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

	public boolean isAvoid() {
		return avoid;
	}

	public void setAvoid(boolean avoid) {
		this.avoid = avoid;
	}

	
}
