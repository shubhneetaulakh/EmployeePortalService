package com.socgen.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(ResponseExceptionHandler.class);
	
	@ExceptionHandler(EmployeePortalException.class)
	  public final ResponseEntity<ErrorResponse> handleOMException(EmployeePortalException ex, WebRequest request) {

	    LOG.error("Exception caught :- {}", ex);
	    ErrorResponse errorResponse = new ErrorResponse(ex);
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	  }
}
