package com.tenzaWeb.admin.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.service.CatagoryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ACatagoryController {
	
	@Autowired
	CatagoryService catagoryService;
	
	

	@RequestMapping("/addcategory")
	public String showCatagoryPage(Model model) {
		
		List<Catagory> catagory=catagoryService.getAllCatagory();
		model.addAttribute("category", new Catagory());
		model.addAttribute("catagory" , catagory);
		return "admin/addCategory";
		
	}
	
	@PostMapping("/savecatagory")
	public String saveCatagory(Model model , @Valid Catagory catagory , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "addCatagory";
		}
	catagoryService.save(catagory);
	
	return "redirect:/addcategory";
	}
	
	
	
	
}
