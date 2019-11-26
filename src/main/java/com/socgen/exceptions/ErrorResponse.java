package com.socgen.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class ErrorResponse {

	  @Getter
	  @Setter
	  @JsonProperty("Message")
	  private String errorMessage;

	  @Getter
	  @Setter
	  @JsonProperty("Code")
	  private String errorCode;
	  
	  /**
	   * 
	   * @param e
	   */
	  public ErrorResponse(EmployeePortalException e) {
	    this.errorMessage = e.getErrorMessage();
	    this.errorCode = e.getErrorCode();
	  }
}
