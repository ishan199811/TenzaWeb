package com.tenzaWeb.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tenzaWeb.user.model.request.UserDTO;
import com.tenzaWeb.user.service.UserService;
import com.tenzaWeb.user.service.ValidationService;


@Service
public class ValidationServiceImpol implements ValidationService {
	
	
	@Autowired
	UserService userService;
	
	
	
	public void userValidate(UserDTO userDto , Model model) {
		if (userService.existsByemail(userDto.getEmail())) {
			model.addAttribute("e","email already registerd" );

		
		}
		if (userService.existsByMobileNumber(userDto.getMobileNumber())) {
			model.addAttribute("m","Mobile Number already registerd" );

			
		}

		
	}

}
