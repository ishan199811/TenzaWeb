package com.tenzaWeb.product.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class Image {

	public long getImageId() {
		return imageId;
	}
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}
	public String getImageurl1() {
		return imageurl1;
	}
	public void setImageurl1(String imageurl1) {
		this.imageurl1 = imageurl1;
	}
	public String getImageurl2() {
		return imageurl2;
	}
	public void setImageurl2(String imageurl2) {
		this.imageurl2 = imageurl2;
	}
	public String getImageurl3() {
		return imageurl3;
	}
	public void setImageurl3(String imageurl3) {
		this.imageurl3 = imageurl3;
	}
	public String getImageurl4() {
		return imageurl4;
	}
	public void setImageurl4(String imageurl4) {
		this.imageurl4 = imageurl4;
	}
	public String getImageurl5() {
		return imageurl5;
	}
	public void setImageurl5(String imageurl5) {
		this.imageurl5 = imageurl5;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long imageId;
	private String imageurl1;
	private String imageurl2;
	private String imageurl3;
	private String imageurl4;
	private String imageurl5;
	
	
}
