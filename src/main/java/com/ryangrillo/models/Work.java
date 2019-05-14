package com.ryangrillo.models;

public class Work {
	
	private Light light;
	
	private Moderate moderate;
	
	private Heavy heavy;

	public Work(Light light, Moderate moderate, Heavy heavy) {
		super();
		this.light = light;
		this.moderate = moderate;
		this.heavy = heavy;
	}

	public Light getLight() {
		return light;
	}

	public void setLight(Light light) {
		this.light = light;
	}

	public Moderate getModerate() {
		return moderate;
	}

	public void setModerate(Moderate moderate) {
		this.moderate = moderate;
	}

	public Heavy getHeavy() {
		return heavy;
	}

	public void setHeavy(Heavy heavy) {
		this.heavy = heavy;
	}
	
	
	
}
