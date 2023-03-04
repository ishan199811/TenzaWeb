package com.tenzaWeb.product.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long imageId;
	
}