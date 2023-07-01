package com.tenzaWeb.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenzaWeb.security.model.dto.UserDto;
import com.tenzaWeb.security.service.UserService;
import com.tenzaWeb.security.util.AuthUtil;







@Controller
public class RegistrationController {
	
	
	
	@Autowired
	private UserService userService; 
	@RequestMapping("/register")
	public String registerationPage(Model model) {
		//("......................................hellopage");
		model.addAttribute("user", new UserDto());

		return "Register";

	}
	
	@RequestMapping("/register2")
	public String schedulepage2(Model model) {
		//("......................................hellopage");
		model.addAttribute("user", new UserDto());

		return "Register2";

	}
	
	@PostMapping("/registrations")
	public String savee(@ModelAttribute("user") UserDto userDto, BindingResult bindingResult ,Model model) throws Exception {
		
		/*
		 * if (userService.existsByemail(userDto.getEmail())) {
		 * model.addAttribute("e","email already registerd" );
		 * 
		 * return "reggg"; }
		 */
		 
		userService.saveData(userDto , bindingResult , model);
		
		//("hello node has been created ______________________________________________________________");
	//	securityService.autoLogin(userDto.getUserId(), userDto.getConfirmPassword()); 
		//userService.saveNode();
		//("......................................hello1");

		return "UserDisplay";
		
		  } 
				
	
	@PostMapping("/withoutrefrenceregistration")
	public String save(@ModelAttribute("user") UserDto userDto, BindingResult bindingResult ,Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			//("Error" + bindingResult);

			return "regg";
		}
		
		
		 
		userService.saveDataa(userDto, bindingResult , model);
		
		//("hello node has been created ______________________________________________________________");
	//	securityService.autoLogin(userDto.getUserId(), userDto.getConfirmPassword()); 
		//userService.saveNode();
		//("......................................hello1");

		return "redirect:/otppage";
		
		  } 
			 		
	
	
	
	

}
