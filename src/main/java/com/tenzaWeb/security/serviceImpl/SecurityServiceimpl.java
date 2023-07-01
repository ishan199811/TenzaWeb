package com.tenzaWeb.security.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.tenzaWeb.security.service.SecurityService;
;


@Service
public class SecurityServiceimpl implements SecurityService {

	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserDetailsService userDetailsService;
	    

	  

	 private static final Logger logger = LoggerFactory.getLogger(SecurityServiceimpl.class);
	
	
	
	@Override
	public void autoLogin(String loginId, String password) throws Exception {
		 UserDetails userDetails = userDetailsService.loadUserByUsername(loginId);
	       // log.info("-----------------------------"+userDetails.getUsername());
	        //log.info("-----------------------------"+userDetails);
	    
	        
	        
	        UsernamePasswordAuthenticationToken auth = 
	        		new UsernamePasswordAuthenticationToken
	        		(userDetails, password, userDetails.getAuthorities());
	       
	       
	     	 authenticationManager.authenticate( auth); 			
	       //log.info(password+"this is password--------hello--------------------------------");

	        if (auth.isAuthenticated()) {
	            SecurityContextHolder.getContext().setAuthentication(auth);
	            logger.debug(String.format("Auto login %s successfully!", loginId));
	        }
	        else {
	        	logger.debug(String.format("Auto login %s failed!", loginId));
	        }
	    
		
	}

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
	public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (userDetails instanceof UserDetails) {
		
	 
			return ((UserDetails) userDetails).getUsername();
		}

		return null;
	}
	}


