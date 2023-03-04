package com.tenzaWeb.user.controller;

import java.util.List;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.stream.Collectors; 
import com.tenzaWeb.product.model.entity.Product;
import com.tenzaWeb.product.service.ProductService;
import com.tenzaWeb.user.model.Reference;
import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.model.request.OTPDto;
import com.tenzaWeb.user.model.request.UserDTO;
import com.tenzaWeb.user.model.request.util.AuthUtil;
import com.tenzaWeb.user.repositotry.ReferenceRepository;
import com.tenzaWeb.user.repositotry.UserRepository;
import com.tenzaWeb.user.service.MessageService;
import com.tenzaWeb.user.service.SecurityService;
import com.tenzaWeb.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	MessageService messageservice;

	@Autowired
	UserRepository userRepo;
	
	@Autowired 
	ReferenceRepository refrepo;

	@Autowired
	ProductService productService;
	
	@Autowired
	ReferenceRepository ref;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@RequestMapping("/register")
	public String schedulepage(Model model) {
		//("......................................hellopage");
		model.addAttribute("user", new UserDTO());

		return "regg";

	}
	
	@RequestMapping("/sponseredId")
	public String schedulRegister(Model model) {
		//("......................................hellopage");
		model.addAttribute("user", new UserDTO());

		return "reggg";

	}
	

	@PostMapping("/registrations")
	public String savee(@ModelAttribute("user") UserDTO userDto, BindingResult bindingResult ,Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			//("Error" + bindingResult);

			return "reggg";
		}
		
		
		/*
		 * if (userService.existsByemail(userDto.getEmail())) {
		 * model.addAttribute("e","email already registerd" );
		 * 
		 * return "reggg"; }
		 */
		  String refId=userDto.getRefenceId();
		  				

		  if(userService.existsByMobileNumber(userDto.getMobileNumber())) {
		  model.addAttribute("m","Mobile Number already registerd" );
		  
		  return "reggg"; 
		  }
		 	
		 if(userRepo.existsByUserId(refId)) { 
         String userId=AuthUtil.generateUserId();
		//("......................................hello");
		
		userDto.setUserId(userId);
		
		userService.saveData(userDto);
		
		//("hello node has been created ______________________________________________________________");
		securityService.autoLogin(userDto.getUserId(), userDto.getConfirmPassword()); 
		userService.saveNode();
		//("......................................hello1");

		return "redirect:/otppage";
		
		  } 
					  model.addAttribute("w", "refrence id does not match"); 
			  return "reggg"; 
			  }

	

	@PostMapping("/registration")
	public String save(@ModelAttribute("user") UserDTO userDto, BindingResult bindingResult ,Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			//("Error" + bindingResult);

			return "regg";
		}
		
		
		  if (userService.existsByemail(userDto.getEmail())) {
		  model.addAttribute("e","email already registerd" );
		 
		  return "regg"; }
		 
		  String refId=userDto.getRefenceId();
		  				

		  if(userService.existsByMobileNumber(userDto.getMobileNumber())) {
		  model.addAttribute("m","Mobile Number already registerd" );
		  
		  return "regg"; 
		  }
		 	
	 
         String userId=AuthUtil.generateUserId();
		//("......................................hello");
		
		userDto.setUserId(userId);
		
		userService.saveDataa(userDto);
		
		//("hello node has been created ______________________________________________________________");
		securityService.autoLogin(userDto.getUserId(), userDto.getConfirmPassword()); 
		userService.saveNode();
		//("......................................hello1");

		return "redirect:/otppage";
		
		  } 
			 			 

	
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {

    	
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        return "login";
        }
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "home";
    }
	
	@RequestMapping("/otppage")
	public String otppage(Model model) {
		model.addAttribute("dto", new OTPDto());
		//("otp page...................");
		return "VerifyOtp";

	}

	@PostMapping("/otpverify")
	public String otpverification(@ModelAttribute("dto") OTPDto dto, Model model, RedirectAttributes redirAttrs,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			//("Error" + bindingResult);

			return "VerifyOtp";
		}
		String userId = securityService.findLoggedInUsername();
		User user = userService.findByUserId(userId);
		dto.setEmail(user.getEmail());
		
		boolean result = messageservice.verifyotp(dto);
		
		if (result == false) {
			redirAttrs.addFlashAttribute("success", "please enter valid otp.");
		
			return "redirect:/otppage";
		}
		messageservice.sendEmail(user.getEmail(), "email", userService.prepareUserIdMessage());
		redirAttrs.addFlashAttribute("succes", "Your Id has been send to your Registered Email");
		
		List<Product> product = productService.getAllProduct();
		model.addAttribute("product", product);
		
		return "index";

	}

	@RequestMapping(value = "/resendotp", method = RequestMethod.GET)
	public String resendotp() {
		String userId = securityService.findLoggedInUsername();
		User user = userService.findByUserId(userId);
		//("mmmmmmmmmmmmmmmmm                helo" + user.getEmail());

		userService.resendotp(user.getEmail());

		return "redirect:/otppage";

	}

	@RequestMapping(value = "/forgestpassword")
	public String forgetpassemailpage( RedirectAttributes redirAttrs,Model model) {
		model.addAttribute("dto", new OTPDto());
		return "forgetpassemail";

	}

	@RequestMapping(value = "/forgestpasswordotp", method = RequestMethod.POST)
	public String forgetpassotppage(@ModelAttribute("dto") OTPDto dto,Model model,RedirectAttributes redirAttrs) {
		////("forget password     "+dto.getEmail());
		
		if(userService.existsByemail(dto.getEmail()))
		{
			userService.resendotp(dto.getEmail());
			return "forgetpassotp";
		}
         
		 model.addAttribute("email","please enter valid email");

		 return "forgetpassemail";

	}
	
	@RequestMapping(value = "/forgestpasswordotpverify", method = RequestMethod.POST)
	public String forgetpasswordotp(@ModelAttribute("dto") OTPDto dto, Model model, RedirectAttributes redirAttrs)
	{//("forget password     "+dto.getEmail());
		
		boolean result = messageservice.verifyotp(dto);
	//("mmmmmmmmmmmmmmmmmmmmmmmm             " + result);
	
	if (result == false) {
		//redirAttrs.addFlashAttribute("success", "please enter valid otp.");
		 model.addAttribute("otp","please enter valid otp");
		return "forgetpassotp";
	}
//	Employee user=userService.findByemail(dto.getEmail());
//	//("  helo           "+user);
//	PasswordDto passdto=new PasswordDto();
//	passdto.setEmail(user.getEmail());
//	model.addAttribute("passdto",passdto);
	

	return "changepass";
	
	}

	@RequestMapping(value = "/reset_password", method = RequestMethod.POST)
	public String changepassword(@ModelAttribute("dto") OTPDto dto,Model model)
	{
		if(!dto.getPassword().equals(dto.getConfirmPasword()))
		{
			//("password incorrect");
			model.addAttribute("passerorr", "please enter valid password.");
			return "changepass";
		}
		//("                      "+dto.getEmail());
		userService.resetpassword(dto);
		
		

	return "redirect:/loginpage";
	
	}

	@RequestMapping("/getreference")
	public String getReferenceByUser(Model model) {
		String referenceId=securityService.findLoggedInUsername();
	List<Reference> user=userService.getUserByReferenceId(referenceId);
	
	
	for(Reference r:user) {
		String position=r.getPosition();
		String l="left";
		String ri="right";
		if(position!=l) {
			List<Reference> refl=userService.getUserByReferenceId(referenceId); 
			model.addAttribute("refll",refl);
			System.out.println(refl +"--------------------------------------------------");
		}
		if(position!=ri) {
			List<Reference> refl=userService.getUserByReferenceId(referenceId); 
			model.addAttribute("refr",refl);	
		}
	}
		model.addAttribute("user",user);
	return "refuser";
	}
	
	@RequestMapping("/chain")
	public String showChain() {
		
		return "chainn";
	}
	@RequestMapping("/imchain")
	public String showimChain() {
		
		return "imchain";
	}
}
