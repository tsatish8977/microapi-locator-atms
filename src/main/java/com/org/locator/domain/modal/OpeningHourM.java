package com.org.locator.domain.modal;

import java.util.List;

public class OpeningHourM {
	private int dayOfWeek;
	private List<HourM> hours;

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<HourM> getHours() {
		return hours;
	}

	public void setHours(List<HourM> hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "OpeningHourM [dayOfWeek=" + dayOfWeek + ", hours=" + hours + "]";
	}
}
