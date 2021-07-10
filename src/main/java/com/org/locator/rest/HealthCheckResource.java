package com.org.locator.rest;

import org.springframework.boot.actuate.health.Health;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Satish Kumar T
 * micro service heanth check controller.
 */
@RestController
public class HealthCheckResource {

	@GetMapping(path = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
	public Health doHealthCheck() {
		return Health.up().build();
	}
}
