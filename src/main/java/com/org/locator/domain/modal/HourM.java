package com.org.locator.domain.modal;

public class HourM {
	private String hourFrom;
	private String hourTo;

	public String getHourFrom() {
		return hourFrom;
	}

	public void setHourFrom(String hourFrom) {
		this.hourFrom = hourFrom;
	}

	public String getHourTo() {
		return hourTo;
	}

	public void setHourTo(String hourTo) {
		this.hourTo = hourTo;
	}

	@Override
	public String toString() {
		return "HourM [hourFrom=" + hourFrom + ", hourTo=" + hourTo + "]";
	}
}
