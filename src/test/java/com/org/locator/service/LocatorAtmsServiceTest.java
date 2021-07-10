package com.org.locator.service;

import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.locator.domain.modal.AddressM;
import com.org.locator.domain.modal.AtmLocatorM;

/**
 * Test class for LocatorAtmsService
 * 
 * @author Satish Kumar T
 *
 */
@ExtendWith(SpringExtension.class)
public class LocatorAtmsServiceTest {
	@SpyBean
	private LocatorAtmsService locatorAtmsService;

	@MockBean
	private RestTemplate restTemplate;

	@MockBean
	private ObjectMapper objectMapper;

	List<AtmLocatorM> atmLocatorsList;

	@BeforeEach
	void init() throws IOException {
		AtmLocatorM atmLocatorM = new AtmLocatorM();
		AddressM address = new AddressM();
		address.setCity("Den Oever");
		address.setStreet("Laan Bloys van Treslong");
		address.setHousenumber("27");
		address.setPostalcode("1779 BA");
		atmLocatorM.setAddress(address);
		atmLocatorM.setDistance(10);
		atmLocatorM.setFunctionality("Geldautomaat");
		atmLocatorM.setOpeningHours(null);
		atmLocatorM.setType("GELDMAAT");
		atmLocatorsList = new ArrayList<>();
		atmLocatorsList.add(atmLocatorM);

		doReturn(atmLocatorsList).when(locatorAtmsService).invokeExternalService();
	}

	@Test
	void testFinaAllAtms() throws IOException {
		assertEquals(locatorAtmsService.findAllAtms(), atmLocatorsList);
		assertEquals(locatorAtmsService.findAllAtmsByCity("city eq 'Den Oever'"), atmLocatorsList);
	}
}
