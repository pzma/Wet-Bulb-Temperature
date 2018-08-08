package com.ryangrillo.models;

import java.util.List;

public class Result {

	private List<AddressComponent> address_components = null;

	private String formatted_address;

	private Geometry geometry;

	private String placeId;

	private List<String> types = null;

	public Result() {
	}

	public Result(List<AddressComponent> addressComponents, String formattedAddress, Geometry geometry, String placeId,
			List<String> types) {
		super();
		this.address_components = addressComponents;
		this.formatted_address = formattedAddress;
		this.geometry = geometry;
		this.placeId = placeId;
		this.types = types;
	}

	public List<AddressComponent> getAddressComponents() {
		return address_components;
	}

	public void setAddressComponents(List<AddressComponent> addressComponents) {
		this.address_components = addressComponents;
	}

	public String getFormattedAddress() {
		return formatted_address;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formatted_address = formattedAddress;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Result [addressComponents=" + address_components + ", formattedAddress=" + formatted_address
				+ ", geometry=" + geometry + ", placeId=" + placeId + ", types=" + types + "]";
	}

}