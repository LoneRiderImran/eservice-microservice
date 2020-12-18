package com.whoofy.eservice.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.whoofy.eservice.enums.ApplicationStatus;

public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String userId;

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
	
	private byte[] resume;
	
	private ApplicationStatus status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

}
