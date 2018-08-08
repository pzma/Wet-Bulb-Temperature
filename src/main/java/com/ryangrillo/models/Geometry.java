package com.ryangrillo.models;

public class Geometry {

	private Bounds bounds;

	private GoogleLocation location;

	private String location_type;

	private Viewport viewport;

	public Geometry() {
	}

	public Geometry(Bounds bounds, GoogleLocation location, String location_type, Viewport viewport) {
		super();
		this.bounds = bounds;
		this.location = location;
		this.location_type = location_type;
		this.viewport = viewport;
	}

	public Bounds getBounds() {
		return bounds;
	}

	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}

	public GoogleLocation getLocation() {
		return location;
	}

	public void setLocation(GoogleLocation location) {
		this.location = location;
	}

	public String getLocationType() {
		return location_type;
	}

	public void setLocationType(String locationType) {
		this.location_type = locationType;
	}

	public Viewport getViewport() {
		return viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

	@Override
	public String toString() {
		return "Geometry [bounds=" + bounds + ", location=" + location + ", locationType=" + location_type
				+ ", viewport=" + viewport + "]";
	}

}