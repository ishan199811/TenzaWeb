package com.tenzaWeb.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.tenzaWeb.user.service.SecurityService;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class SecurityServiceImpl implements SecurityService {
	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserDetailsService userDetailsService;
	    

	  

	 private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
	 @Override
	 public boolean isAuthenticated() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication == null || AnonymousAuthenticationToken.class.
	            isAssignableFrom(authentication.getClass())) {
	            return false;
	        }
	        return authentication.isAuthenticated();
	    }

	    @Override
	    public void autoLogin(String userId, String password) throws Exception {
	        UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
	       // log.info("-----------------------------"+userDetails.getUsername());
	        //log.info("-----------------------------"+userDetails);
	    
	        
	        
	        UsernamePasswordAuthenticationToken auth = 
	        		new UsernamePasswordAuthenticationToken
	        		(userDetails, password, userDetails.getAuthorities());
	       
	       
	     	 authenticationManager.authenticate( auth); 			
	       //log.info(password+"this is password--------hello--------------------------------");

	        if (auth.isAuthenticated()) {
	            SecurityContextHolder.getContext().setAuthentication(auth);
	            logger.debug(String.format("Auto login %s successfully!", userId));
	        }
	    }
	    @Override
		public String findLoggedInUsername() {
			Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (userDetails instanceof UserDetails) {
			
		 
				return ((UserDetails) userDetails).getUsername();
			}

			return null;
		}
	

}
