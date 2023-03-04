package com.tenzaWeb.payment.model.entity;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Payment {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long paymentId;
	
private String merchantId;
	
	private String merchantKey;
	
	private String channelId;
	
	private String website;
	
	private String paymentMode;
	
	private String paymentStatus;
	

}
