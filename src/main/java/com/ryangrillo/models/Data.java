package com.ryangrillo.models;

import java.util.List;

public class Data {

	private List<String> temperature = null;

	private List<Object> pop = null;

	private List<String> weather = null;

	private List<String> iconLink = null;

	private List<String> hazard = null;

	private List<String> hazardUrl = null;

	private List<String> text = null;

	public Data() {
	}

	public Data(List<String> temperature, List<Object> pop, List<String> weather, List<String> iconLink,
			List<String> hazard, List<String> hazardUrl, List<String> text) {
		super();
		this.temperature = temperature;
		this.pop = pop;
		this.weather = weather;
		this.iconLink = iconLink;
		this.hazard = hazard;
		this.hazardUrl = hazardUrl;
		this.text = text;
	}

	public List<String> getTemperature() {
		return temperature;
	}

	public void setTemperature(List<String> temperature) {
		this.temperature = temperature;
	}

	public List<Object> getPop() {
		return pop;
	}

	public void setPop(List<Object> pop) {
		this.pop = pop;
	}

	public List<String> getWeather() {
		return weather;
	}

	public void setWeather(List<String> weather) {
		this.weather = weather;
	}

	public List<String> getIconLink() {
		return iconLink;
	}

	public void setIconLink(List<String> iconLink) {
		this.iconLink = iconLink;
	}

	public List<String> getHazard() {
		return hazard;
	}

	public void setHazard(List<String> hazard) {
		this.hazard = hazard;
	}

	public List<String> getHazardUrl() {
		return hazardUrl;
	}

	public void setHazardUrl(List<String> hazardUrl) {
		this.hazardUrl = hazardUrl;
	}

	public List<String> getText() {
		return text;
	}

	public void setText(List<String> text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Data [temperature=" + temperature + ", pop=" + pop + ", weather=" + weather + ", iconLink=" + iconLink
				+ ", hazard=" + hazard + ", hazardUrl=" + hazardUrl + ", text=" + text + "]";
	}

}