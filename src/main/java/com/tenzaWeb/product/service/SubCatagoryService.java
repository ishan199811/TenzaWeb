package com.tenzaWeb.product.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenzaWeb.product.model.entity.SubCatagory;
import com.tenzaWeb.product.repository.SubCatagoryRepository;

@Service
public class SubCatagoryService {

	
	@Autowired
	SubCatagoryRepository subRepo;
	
	
	public List<SubCatagory> getAllSub() {
		// TODO Auto-generated method stub
		return subRepo.findAll();
	}


	public void save(@Valid SubCatagory subCatagory) {
		
		subRepo.save(subCatagory);
		
	}

}
