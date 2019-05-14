package com.ryangrillo.models;

public class Light {
	
	private String active;
	
	private String rest;
	
	private String water;
	

	public Light(String active, String rest, String water) {
		super();
		this.active = active;
		this.rest = rest;
		this.water = water;
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
	
	
}
