package com.tenzaWeb.user.model.request;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;


public class OTPDto {
	@Email(message = "Please enter same email address.")
	@NotBlank
	private String email;
	@NotBlank
	@Size(min=4 , max=4 , message = "Please enter valid OTP.")
	private String otp;
	
	public String password;
	public String confirmPasword;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPasword() {
		return confirmPasword;
	}
	public void setConfirmPasword(String confirmPasword) {
		this.confirmPasword = confirmPasword;
	}
	
	

}
