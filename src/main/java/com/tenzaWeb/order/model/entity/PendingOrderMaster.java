package com.tenzaWeb.order.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PendingOrderMaster {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long PendingId;
	
Long orderId;
	
String createdBy;
	
	Date createdAt;
	
	String updatedBy;
	
	Date updatedAt;
}
