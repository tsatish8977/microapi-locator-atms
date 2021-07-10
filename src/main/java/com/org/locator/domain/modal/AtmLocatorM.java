package com.org.locator.domain.modal;

import java.util.List;

public class AtmLocatorM {
	private AddressM address;
	private int distance;
	private List<OpeningHourM> openingHours;
	private String functionality;

	public AddressM getAddress() {
		return address;
	}

	public void setAddress(AddressM address) {
		this.address = address;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<OpeningHourM> getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(List<OpeningHourM> openingHours) {
		this.openingHours = openingHours;
	}

	public String getFunctionality() {
		return functionality;
	}

	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;

	@Override
	public String toString() {
		return "AtmLocatorM [address=" + address + ", distance=" + distance + ", openingHours=" + openingHours
				+ ", functionality=" + functionality + ", type=" + type + "]";
	}
}
