package com.tenzaWeb.address.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenzaWeb.address.model.entity.Address;
import com.tenzaWeb.address.service.AdderessService;
import com.tenzaWeb.cart.model.request.CartDTO;
import com.tenzaWeb.cart.model.request.CartItemDto;
import com.tenzaWeb.order.model.entity.OrderMaster;
import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.service.SecurityService;
import com.tenzaWeb.user.service.UserService;

@Controller
public class AddressController {
	
	@Autowired
	AdderessService addressService;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired 
	UserService userService;
	
	
	@RequestMapping("/address")
	public String getAddressPage(Model model) {
		
		
		model.addAttribute("address", new Address());
		
		return "address";
		
		
	}
	
		
	@PostMapping("/saveaddres")
	public String saveAddress( Model model , @Valid Address address , BindingResult bindingResult) {
		
		  if (bindingResult.hasErrors()) {       
	            return "address";
	 } 
		
		  addressService.save(address);					
		return "redirect:/checkout";
	}

		
	

}
