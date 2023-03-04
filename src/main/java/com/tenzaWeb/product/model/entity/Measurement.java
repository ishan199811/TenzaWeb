package com.tenzaWeb.product.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Measurement {

	
	@Id
	@GeneratedValue()
	private long measurementId;
	
    private String measurementName;
	
	private String measurementSymbol;
	
	
	
}
