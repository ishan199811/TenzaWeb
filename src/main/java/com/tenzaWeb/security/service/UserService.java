package com.tenzaWeb.security.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.tenzaWeb.security.model.dto.UserDto;
import com.tenzaWeb.security.model.entity.Role;
import com.tenzaWeb.security.model.entity.User;



public interface UserService {



	

	String saveData(UserDto userDto, BindingResult bindingResult, Model model) throws Exception;

	boolean existsByMobileNumber(String mobileNo);

	User findByUserId(String username);

	

	

	

	String saveDataa(UserDto userDto, BindingResult bindingResult, Model model);

	boolean existsByemail(String email);

	User findByLoginId(String loginId);

	List<User> listAll();

	void saveRole(Role role);

	void save(User user);

	User get(String userId);

	List<Role> listRoles();

	

}
