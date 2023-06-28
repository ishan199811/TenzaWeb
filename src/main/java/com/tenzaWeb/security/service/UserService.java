package com.tenzaWeb.security.service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.tenzaWeb.security.model.dto.UserDto;
import com.tenzaWeb.security.model.entity.User;



public interface UserService {



	

	String saveData(UserDto userDto, BindingResult bindingResult, Model model) throws Exception;

	boolean existsByMobileNumber(String mobileNo);

	User findByUserId(String username);

	

	

	

	String saveDataa(UserDto userDto, BindingResult bindingResult, Model model);

	boolean existsByemail(String email);

	

}
