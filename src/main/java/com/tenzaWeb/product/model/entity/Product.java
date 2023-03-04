package com.tenzaWeb.product.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity

@NoArgsConstructor
@AllArgsConstructor

public class Product {

	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Brand getBrandId() {
		return brandId;
	}

	public void setBrandId(Brand brandId) {
		this.brandId = brandId;
	}

	public Catagory getCatagoryId() {
		return catagoryId;
	}

	public void setCatagoryId(Catagory catagoryId) {
		this.catagoryId = catagoryId;
	}

	public SubCatagory getSubCatagoryId() {
		return subCatagoryId;
	}

	public void setSubCatagoryId(SubCatagory subCatagoryId) {
		this.subCatagoryId = subCatagoryId;
	}

	public Measurement getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Measurement measurementId) {
		this.measurementId = measurementId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(String productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	 Long productId;


	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brandId;

	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catagory_id", nullable = false)
	private Catagory catagoryId;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subCatagory_id", nullable = false)
	private SubCatagory subCatagoryId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "measurement_id" , nullable = false)
	private Measurement measurementId;
	
	
	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "product") //private List<Cart>
	 * carts;
	 */
	 String productName;

	 double productPrice;

	String productDiscount;

	 String imageUrl;

	 String productDescription;

	public void setImageUrl(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
