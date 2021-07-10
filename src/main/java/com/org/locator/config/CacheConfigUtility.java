package com.org.locator.config;

import java.util.ArrayList;
import java.util.List;

import com.org.locator.domain.modal.AtmLocatorM;

/**
 * cache utility class to store external service response.
 * can be extended to external cache (redis). 
 * This will improve the api performance instead making call to external service every time.
 * 
 * @author Satish Kumar T
 *
 */
public class CacheConfigUtility {

	public static List<AtmLocatorM> atmLocators = new ArrayList<>();

	public static List<AtmLocatorM> getAtmLocators() {
		return atmLocators;
	}

	public static void setAtmLocators(List<AtmLocatorM> atmLocators) {
		CacheConfigUtility.atmLocators = atmLocators;
	}
}
