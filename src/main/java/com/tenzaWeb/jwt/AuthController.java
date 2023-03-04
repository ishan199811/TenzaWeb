package com.tenzaWeb.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenzaWeb.user.service.impl.MyUserDetails;

import io.jsonwebtoken.JwtBuilder;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/auth/")
@Slf4j
public class AuthController {

	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	UserDetailsService userDetailService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest authRequest){
		//log.info(  "helooooooooooooooooooooooooooooooooh"+authRequest);
		System.out.println("---"+authRequest);
		this.authenticate(authRequest.getUsername(),authRequest.getPassword());
	
MyUserDetails userDetails=(MyUserDetails) this.userDetailService.loadUserByUsername(authRequest.getUsername());
		
String generatedToken = this.jwtTokenHelper.generateToken(userDetails);



JwtAuthResponse response=new JwtAuthResponse();
response.setToken(generatedToken);
return new ResponseEntity<JwtAuthResponse>(response , HttpStatus.OK);
}


	private void authenticate(String username, String password) {
UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(username,password);
		
try{
	this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
}
catch(DisabledException e) {
	System.out.println("User is disable ");
	}
  }
}
