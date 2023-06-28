package com.tenzaWeb.security.util;

import java.util.Random;

public class AuthUtil {
	
	public static String generateUserId()
	{
		Random rand = new Random();
		return String.format("%08d", rand.nextInt(100000000));
	}
	
	public static String generatepassword()
	{
		Random rand = new Random();
		return String.format("%05d", rand.nextInt(100000));
	}

	public static String generate4DigitNumber()
	{
		Random rand = new Random();
		return String.format("%04d", rand.nextInt(10000));
	}
}


