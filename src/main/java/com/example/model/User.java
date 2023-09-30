package com.example.model;

//import javax.validation.constraints.NotNull;

public class User {
	public String userName;
	public String password;
	public String mobileNumber;
	public String emailId;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", mobileNumber=" + mobileNumber + ", emailId="
				+ emailId + "]";
	}

}
