package com.tenzaWeb.security.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tenzaWeb.security.model.entity.User;
import com.tenzaWeb.security.service.UserService;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserService userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		User user = userService.findByLoginId(loginId);
		
		
		if(user==null)
		{
			
			throw new UsernameNotFoundException("Could not found user !!");
		}
		  MyUserDetails customUserDetails=new MyUserDetails(user);
		  return customUserDetails;
	}

}
