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

public class Catagory {
	
	public Long getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(Long catagoryId) {
		this.catagoryId = catagoryId;
	}

	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long catagoryId;
	
	 String catagoryName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catagoryId", cascade = CascadeType.ALL)
	private Set<Product> products = new HashSet<Product>(); 
	

}
