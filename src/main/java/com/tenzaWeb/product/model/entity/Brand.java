package com.tenzaWeb.product.model.entity;

import java.util.ArrayList;
import java.util.List;

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
public class Brand {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long brandId;
	
	String brandName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brandId", cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>(); 
	 
}
