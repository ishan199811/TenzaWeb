package com.tenzaWeb.product.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.Data;

@Entity
@Data
public class Catagory {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long catagoryId;
	
	 String catagoryName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catagoryId", cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<Product>(); 
	

}
