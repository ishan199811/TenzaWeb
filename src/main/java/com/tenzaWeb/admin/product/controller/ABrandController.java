package com.tenzaWeb.admin.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenzaWeb.product.model.entity.Brand;
import com.tenzaWeb.product.service.BrandService;


@Controller
//@RequestMapping("/admin")
public class ABrandController {
	
	
	@Autowired
	BrandService brandService;
	
	
	
	@RequestMapping("/addbrand")
public String showAddNewBrandPage(Model model) {

	List<Brand> brand=brandService.getAllBrand();
		model.addAttribute("brand1" , brand);
		model.addAttribute("brand", new Brand());
		
		return "admin/addbrand";
		
		
	}
	
	
	
	 @PostMapping("/savebrand") 
	  public String  editForm(@Valid @ModelAttribute("brand") Brand brand,BindingResult
	  bindingResult) {
	  
	  
	 if (bindingResult.hasErrors()) {
	 
	 return "updateCarrer"; 
	 } 
	 else
	 {
	 
	 brandService.save(brand); 
	 return "redirect:/addbrand"; 
	    }
	 }
	
	
	

}
