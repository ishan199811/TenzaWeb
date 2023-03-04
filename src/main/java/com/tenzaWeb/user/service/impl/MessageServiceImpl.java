package com.tenzaWeb.user.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.model.request.OTPDto;
import com.tenzaWeb.user.model.request.util.CacheManager;
import com.tenzaWeb.user.repositotry.UserRepository;
import com.tenzaWeb.user.service.MessageService;
import com.tenzaWeb.user.service.SecurityService;

import lombok.extern.slf4j.Slf4j;





@Slf4j
@Service
public class MessageServiceImpl implements MessageService{
	
	 @Autowired
	    JavaMailSender javaMailSender;
	 @Autowired
	    private Environment env;
	 @Autowired
	UserRepository userRepo;
	
	 @Autowired
	 SecurityService sc;
	 
	 private Object Date;

	@Override
	public void sendEmail(String email, String message, String subject) {
		SimpleMailMessage msg = new SimpleMailMessage();
		
        msg.setTo(env.getProperty("spring.mail.username"),email);
       

        msg.setSubject(subject);
        msg.setText(message);

       javaMailSender.send(msg);
		
	}
	
	

	@Override
	public boolean verifyotp(OTPDto dto) {
		
		//log.info("gggggggggggggggg         msg service");
		
		String result = null;

		Map map = CacheManager.getOTP(dto.getEmail());
		if(map==null || map.isEmpty()) {
			result="Invalid";
		
			return false ;
		}
		
		Date time ;
		 time= (java.util.Date) map.get("time");
		//Date time=(Date)map.get("time");
		Date today = new Date();
		String otp = (String) map.get("otp");
		
		long sendtime=time.getTime();
		long realtime=today.getTime();
		long diffrencee=realtime-sendtime;
		long diffMinutes = diffrencee / (60 * 1000) % 60;
		
		  if(diffMinutes>5) {
			  result="expired";
			  return false;
		  }
			
		 
		
	
		if (dto.getOtp().equals(otp)) {
			CacheManager.clearOTP(dto.getEmail());
			String userId = sc.findLoggedInUsername();
			User user=userRepo.findByUserId(userId);
			user.setEnable(true);
			userRepo.save(user);
			result="success";
			  return true;
		

		}
		result="invalid";
		return false;

		
		
	}



	
	
	
	
	

}
