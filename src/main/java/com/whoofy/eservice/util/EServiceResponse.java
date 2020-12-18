package com.whoofy.eservice.util;

public class EServiceResponse {

private Object response;
	
	private String failureMessage;
	
	private String status;
	
	private String errorCode;
	
	private String createdAt;

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "PartnerResponse [response=" + response + ", failureMessage=" + failureMessage + ", status=" + status
				+ ", errorCode=" + errorCode + ", createdAt=" + createdAt + "]";
	}

	
}
