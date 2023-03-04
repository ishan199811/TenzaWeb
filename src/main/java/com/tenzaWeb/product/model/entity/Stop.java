package com.tenzaWeb.product.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Stop {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long stopId;
	
	String stopName;
	
	String day;

}
