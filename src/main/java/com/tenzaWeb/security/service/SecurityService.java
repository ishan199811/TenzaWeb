package com.tenzaWeb.security.service;

public interface SecurityService {
	
	void autoLogin(String username, String password) throws Exception;

	boolean isAuthenticated();

	String findLoggedInUsername();


}
