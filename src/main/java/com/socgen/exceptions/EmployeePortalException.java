package com.socgen.exceptions;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeePortalException extends Exception {
	 private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePortalException.class);
	 
	 public EmployeePortalException() {}
	 public EmployeePortalException(String message)
	 {
		 super(message);
	 }
	public String getErrorMessage() {
		return null;
	}
	public String getErrorCode() {
		
		return null;
	}
}
