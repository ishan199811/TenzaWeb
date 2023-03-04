package com.tenzaWeb.user.model.request.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {
	
	private static Map<String, Map>  OTPCache=new  ConcurrentHashMap<String, Map>();
	
	public static void addOTP(Map otpdata,String username)
	{
		OTPCache.put(username, otpdata);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Map> getOTP(String username)
	{
		return OTPCache.get(username);
	}

	
	public static void clearOTP(String username)
	{
		OTPCache.remove(username);
	}

	public static void sendUserId(Map userId, String username) {
		// TODO Auto-generated method stub
		OTPCache.put(username, userId);
	}

}
