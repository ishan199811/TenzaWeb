package com.tenzaWeb.order.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DeliveredOrderMaster {

	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long DeliveredId;
	
	
	
	Long orderId;
	
	Date deliveredOrderDate;
	
	String createdBy;
	
	Date createdAt;
	
	String updatedBy;
	
	Date updatedAt;
	
	
	
}
