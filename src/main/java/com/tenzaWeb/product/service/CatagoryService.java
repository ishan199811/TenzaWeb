package com.tenzaWeb.product.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenzaWeb.product.model.entity.Brand;
import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.repository.CatagoryRepository;

@Service
public class CatagoryService {
	
	@Autowired
	CatagoryRepository catagoryRepository;
	
	public List<Catagory> getAllCatagory() {
		return catagoryRepository.findAll();
	}

	public void save(@Valid Catagory catagory) {
	catagoryRepository.save(catagory);
		
	}

	public void deleteCategoryById(long id) {
		catagoryRepository.deleteById(id);
		
	}

}
