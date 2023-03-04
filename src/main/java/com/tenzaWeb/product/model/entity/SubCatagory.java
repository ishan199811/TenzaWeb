package com.tenzaWeb.product.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



import lombok.Data;


@Entity
@Data
public class SubCatagory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subCatagoryId;
	
	private String subCatagoryName;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subCatagoryId", cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	
	
	
	

}
