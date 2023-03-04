package com.tenzaWeb.user.service;

public interface SecurityService {
	void autoLogin(String username, String password) throws Exception;

	boolean isAuthenticated();

	String findLoggedInUsername();

}
