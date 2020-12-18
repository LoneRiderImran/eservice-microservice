package com.whoofy.eservice.rest.request;

public class ApplicationRequest {

	private String firstName;

	private String lastName;

	private String address;

	private String dob;

	private String mobile;

	private Boolean hasCompletdUg;

	private Boolean hasCompletedPg;

	private Boolean isExperienced;

	private int yearsOfExperience;

	private int expectedSalary;

	private int previousSalary;

	private String positionType;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getHasCompletdUg() {
		return hasCompletdUg;
	}

	public void setHasCompletdUg(Boolean hasCompletdUg) {
		this.hasCompletdUg = hasCompletdUg;
	}

	public Boolean getHasCompletedPg() {
		return hasCompletedPg;
	}

	public void setHasCompletedPg(Boolean hasCompletedPg) {
		this.hasCompletedPg = hasCompletedPg;
	}

	public Boolean getIsExperienced() {
		return isExperienced;
	}

	public void setIsExperienced(Boolean isExperienced) {
		this.isExperienced = isExperienced;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public int getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(int expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public int getPreviousSalary() {
		return previousSalary;
	}

	public void setPreviousSalary(int previousSalary) {
		this.previousSalary = previousSalary;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

}
