package com.org.locator.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler
 * @author Satish Kumar T
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleWorkerException(Exception exe, WebRequest request) {
		LOG.error("Exception occured while processing the request {}", request);
		LOG.error("Exception: ", exe);
		return new ResponseEntity<>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
