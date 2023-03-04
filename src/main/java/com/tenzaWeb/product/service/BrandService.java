package com.tenzaWeb.product.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenzaWeb.product.model.entity.Brand;

import com.tenzaWeb.product.repository.BrandRepository;

@Service
public class BrandService {
	
	@Autowired
	BrandRepository brandRepository;
	
	
	public List<Brand> getAllBrand() {
		return brandRepository.findAll();
	}

	public void save(@Valid Brand brand) {
		
		 brandRepository.save(brand);		
	}

	public Brand getBrandById(long id) {
		
		return brandRepository.findByBrandId(id);
	}
	
	
	public void deleteBrandById(long id) {
		brandRepository.deleteById(id);
	}

	public void get(long id) {
		brandRepository.findById(id).get();
		
	}

}
