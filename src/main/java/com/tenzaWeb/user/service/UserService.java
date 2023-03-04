package com.tenzaWeb.user.service;

import java.util.List;

import com.tenzaWeb.user.model.Reference;
import com.tenzaWeb.user.model.Role;
import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.model.request.OTPDto;
import com.tenzaWeb.user.model.request.UserDTO;

public interface UserService {



	User findByUserId(String userId);
	String resendotp(String email);

	boolean existsByemail(String email);

	User findByemail(String email);

	void resetpassword(OTPDto dto);

	
	String saveData(UserDTO user) throws Exception;
	User get(String userId);
	List<Role> listRoles();
	List<User> listAll();
	void saveRole(Role role);
	void save(User user);
	String prepareUserIdMessage();
	boolean existsByMobileNumber(long mobileNumber);
	
	List<Reference> getUserByReferenceId(String refrenceId);
	public boolean existsByUserId(String refrenceId);
	void saveNode();
	String saveDataa(UserDTO userDto) throws Exception;
	

	



}
