package com.ryangrillo.models;

public class Viewport {

	private Northeast northeast;

	private Southwest southwest;

	public Viewport() {
	}

	public Viewport(Northeast northeast, Southwest southwest) {
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
		return "Viewport [northeast=" + northeast + ", southwest=" + southwest + "]";
	}

}