package com.ryangrillo.models;

import java.util.List;

public class AddressComponent {

	private String long_name;

	private String short_name;

	private List<String> types = null;

	public AddressComponent() {
	}

	public AddressComponent(String longName, String shortName, List<String> types) {
		super();
		this.long_name = longName;
		this.short_name = shortName;
		this.types = types;
	}

	public String getLongName() {
		return long_name;
	}

	public void setLongName(String longName) {
		this.long_name = longName;
	}

	public String getShortName() {
		return short_name;
	}

	public void setShortName(String shortName) {
		this.short_name = shortName;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "AddressComponent [longName=" + long_name + ", shortName=" + short_name + ", types=" + types + "]";
	}

}