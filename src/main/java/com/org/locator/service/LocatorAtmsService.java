package com.org.locator.service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.locator.config.CacheConfigUtility;
import com.org.locator.domain.modal.AtmLocatorM;
import com.org.locator.domain.modal.AtmLocatorWrapperM;

/**
 * @author Satish Kumar T
 *
 */
@Service
public class LocatorAtmsService {
	private static final Logger LOG = LoggerFactory.getLogger(LocatorAtmsService.class);

	@Value("${external.service}")
	private String externalServiceUrl = "https://www.ing.nl/api/locator/atms/";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Get all atms from external service
	 * 
	 * @return List of atms
	 * @throws IOException
	 */
	public List<AtmLocatorM> findAllAtms() throws IOException {
		List<AtmLocatorM> atmLocators = CacheConfigUtility.getAtmLocators();
		LOG.info("finding all atms");
		return CollectionUtils.isNotEmpty(atmLocators) ? atmLocators : invokeExternalService();
	}

	/**
	 * Get all atms by city filter from external service
	 * 
	 * @param filter
	 * @return List<AtmLocatorM>
	 * @throws IOException
	 */
	public List<AtmLocatorM> findAllAtmsByCity(String filter) throws IOException {
		List<AtmLocatorM> atmLocators = CacheConfigUtility.getAtmLocators();
		atmLocators = CollectionUtils.isNotEmpty(atmLocators) ? atmLocators : invokeExternalService();
		String city = parseOdataFilter(filter);
		LOG.info("finding all atms by city = [{}]", city);
		return CollectionUtils.isNotEmpty(atmLocators) ? atmLocators.stream().filter(
				atm -> (null != atm.getAddress() && StringUtils.equalsIgnoreCase(atm.getAddress().getCity(), city)))
				.collect(Collectors.toList()) : null;
	}

	/**
	 * rest call to external service.
	 * 
	 * @return List<AtmLocatorM>
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public List<AtmLocatorM> invokeExternalService() throws JsonMappingException, JsonProcessingException {
		LOG.info("invoking external service rest call [{}] ", externalServiceUrl);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(externalServiceUrl, String.class);
		String response = responseEntity.getBody();
		StringJoiner joiner = new StringJoiner(" ", "{\"atmLocators\":", "}");
		joiner.add(response.substring(5));
		AtmLocatorWrapperM atmLocatorWrapperM = objectMapper.readValue(joiner.toString(), AtmLocatorWrapperM.class);
		CacheConfigUtility
				.setAtmLocators(Objects.nonNull(atmLocatorWrapperM) ? atmLocatorWrapperM.getAtmLocators() : null);
		LOG.info("End of external service rest call");
		return atmLocatorWrapperM.getAtmLocators();
	}

	String parseOdataFilter(String filter) {
		if (filter.contains(" eq ")) {
			String[] params = filter.split(" eq ");
			return "city".equalsIgnoreCase(params[0]) ? params[1].replace("'", "").trim() : StringUtils.EMPTY;
		}
		return StringUtils.EMPTY;
	}
}
