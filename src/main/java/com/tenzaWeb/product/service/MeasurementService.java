package com.tenzaWeb.product.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.model.entity.Measurement;
import com.tenzaWeb.product.repository.MeasurementRepository;

@Service
public class MeasurementService {

	
	@Autowired
	MeasurementRepository measureRepo;
	
	
	public List<Measurement> getAllMeasurement() {
		
		
		return  measureRepo.findAll();
		// TODO Auto-generated method stub
		
	}


	public void save(@Valid Measurement measurement) {
		 measureRepo.save(measurement);
		
	}

}
