package com.tenzaWeb.user.service;

import com.tenzaWeb.user.model.request.OTPDto;

public interface MessageService {
	
	 void sendEmail(String email,String message,String subject);
	 
	 boolean verifyotp(OTPDto dto);
	 
	 

}
