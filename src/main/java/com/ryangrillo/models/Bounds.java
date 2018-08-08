package com.ryangrillo.models;

public class Bounds {

	private Northeast northeast;

	private Southwest southwest;

	public Bounds() {
	}

	public Bounds(Northeast northeast, Southwest southwest) {
		super();
		this.northeast = northeast;
		this.southwest = southwest;
	}

	public Northeast getNortheast() {
		return northeast;
	}

	public void setNortheast(Northeast northeast) {
		this.northeast = northeast;
	}

	public Southwest getSouthwest() {
		return southwest;
	}

	public void setSouthwest(Southwest southwest) {
		this.southwest = southwest;
	}

	@Override
	public String toString() {
		return "Bounds [northeast=" + northeast + ", southwest=" + southwest + "]";
	}

}