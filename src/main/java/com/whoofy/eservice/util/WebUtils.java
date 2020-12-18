package com.whoofy.eservice.util;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class WebUtils {

	public static ResponseEntity<EServiceResponse> successResponse(Object serviceResponse) {
		EServiceResponse response = new EServiceResponse();
		response.setResponse(serviceResponse);
		response.setStatus("SUCCESS");
		response.setFailureMessage("");
		response.setCreatedAt(new Date().toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public static ResponseEntity<EServiceResponse> failureResponse(String failureMessage) {
		EServiceResponse response = new EServiceResponse();
		response.setResponse("");
		response.setStatus("FAILURE");
		response.setFailureMessage(failureMessage);
		response.setCreatedAt(new Date().toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
