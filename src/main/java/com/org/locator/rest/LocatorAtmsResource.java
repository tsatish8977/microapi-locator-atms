package com.org.locator.rest;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.locator.domain.modal.AtmLocatorM;
import com.org.locator.domain.modal.AtmLocatorWrapperM;
import com.org.locator.service.LocatorAtmsService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Satish Kumar T
 *
 */
@RestController
@RequestMapping("/ing")
public class LocatorAtmsResource {

	private static final Logger LOG = LoggerFactory.getLogger(LocatorAtmsResource.class);

	@Autowired
	private LocatorAtmsService locatorAtmsService;

	/**
	 * Get list of atms info, $filter odata can be used to get atms by city
	 * 
	 * @param filter ex: $filter=city eq 'denver'
	 * @return AtmLocatorWrapperM
	 * @throws Exception
	 */
	@GetMapping("/locator/atms/findAll")
	@ApiOperation("Get all locator atms api")
	public AtmLocatorWrapperM findAllAtms(
			@RequestParam(required = false, name = "$filter", defaultValue = "") String filter) throws Exception {
		LOG.info("--Initiate processing /locator/atms/findAll resource");
		List<AtmLocatorM> atmsList = null;
		atmsList = StringUtils.isBlank(filter) ? locatorAtmsService.findAllAtms()
				: locatorAtmsService.findAllAtmsByCity(filter);

		LOG.info("atms found = [{}]", CollectionUtils.isNotEmpty(atmsList) ? atmsList.size() : 0);
		LOG.info("--End of processing resource");
		return AtmLocatorWrapperM.fromBase(atmsList);
	}
}
