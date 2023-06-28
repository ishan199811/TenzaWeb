package com.tenzaWeb.security.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;






public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   long userId;
	
	
String loginId;
	
	String  mrMs;
	
String fullname;
	
	String email;
	
	String mobileNo;
	
	String gender;
	
	String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	String dob ;
	
	String address;
	
	String state;
	
	String sponserId;
	
	String sponserName;
	
	String position ;
	
	String nominne;
	
	String nominneRelation;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_roles", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	Set<Role> roles = new HashSet<>();
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getMrMs() {
		return mrMs;
	}

	public void setMrMs(String mrMs) {
		this.mrMs = mrMs;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSponserId() {
		return sponserId;
	}

	public void setSponserId(String sponserId) {
		this.sponserId = sponserId;
	}

	public String getSponserName() {
		return sponserName;
	}

	public void setSponserName(String sponserName) {
		this.sponserName = sponserName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNominne() {
		return nominne;
	}

	public void setNominne(String nominne) {
		this.nominne = nominne;
	}

	public String getNominneRelation() {
		return nominneRelation;
	}

	public void setNominneRelation(String nominneRelation) {
		this.nominneRelation = nominneRelation;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
	
	
	
	
	
	
	
	
	

}
