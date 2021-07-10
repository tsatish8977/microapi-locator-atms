package com.org.locator.domain.modal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtmLocatorWrapperM {

	private List<AtmLocatorM> atmLocators;

	public List<AtmLocatorM> getAtmLocators() {
		return atmLocators;
	}

	public void setAtmLocators(List<AtmLocatorM> atmLocators) {
		this.atmLocators = atmLocators;
	}

	public static AtmLocatorWrapperM fromBase(List<AtmLocatorM> atmsList) {
		AtmLocatorWrapperM modal = new AtmLocatorWrapperM();
		modal.setAtmLocators(atmsList);
		return modal;
	}

	@Override
	public String toString() {
		return "AtmLocatorWrapperM [atmLocators=" + atmLocators + "]";
	}
}
