package com.whoofy.eservice.exeception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5186352574806674423L;

	private String userNotFound;

	public UserNotFoundException(String userNotFoundCheck) {
		super(String.format("User not found", userNotFoundCheck));
	}

	public String getUserNotFound() {
		return userNotFound;
	}

	public void setUserNotFound(String userNotFound) {
		this.userNotFound = userNotFound;
	}

}
