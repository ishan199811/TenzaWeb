package com.tenzaWeb.user.model.request;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


public class UserDTO {
	//  String title;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   long id;

	
	  public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSimplePasword() {
		return simplePasword;
	}
	public void setSimplePasword(String simplePasword) {
		this.simplePasword = simplePasword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getRefenceId() {
		return refenceId;
	}
	public void setRefenceId(String refenceId) {
		this.refenceId = refenceId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	String userId;
	  String fullName;
	  long mobileNumber;
	  String email;
	  String DOB;
	  String gender;
	  String password;
	  String simplePasword;
	  String confirmPassword;
	  String refenceId;
	  String position;
	

}
