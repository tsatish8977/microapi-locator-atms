package com.org.locator.domain.modal;

public class GeoLocationM {
	private String lat;
	private String lng;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "GeoLocationM [lat=" + lat + ", lng=" + lng + "]";
	}
}
