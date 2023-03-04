package com.tenzaWeb.admin.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.tenzaWeb.product.model.entity.Brand;
import com.tenzaWeb.product.model.entity.Product;
import com.tenzaWeb.product.service.BrandService;
import com.tenzaWeb.product.service.CatagoryService;
import com.tenzaWeb.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EditProduct {

	
	@Autowired
	BrandService bs;
	
	
	@Autowired
	CatagoryService cs;
	
	@GetMapping("/ed/{id}")
	public String showBrandForUpdate(@PathVariable(value="id" ) long id, Model model) {
	
		Brand brand= bs.getBrandById(id);
		 model.addAttribute("brand", brand);
		
		
		return "editProducts.html";
	}
	
	
	
	
	@GetMapping("/de/{id}")
	public String deleteBrand(@PathVariable(value="id") long id) {
	
		 bs.deleteBrandById(id);
		
		
	
		
		return "editProducts.html";
	}
	
	
	
	
	
}
	
	
	
	

