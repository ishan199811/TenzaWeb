package com.tenzaWeb.admin.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenzaWeb.product.model.entity.Measurement;
import com.tenzaWeb.product.model.entity.SubCatagory;
import com.tenzaWeb.product.service.SubCatagoryService;

@Controller
public class ASubCatagoryController {

	
	@Autowired
	SubCatagoryService subService;
	
	
	
	@RequestMapping("/addsubcategory")
	public String showSuubCatagoryPage(Model model) {
		
		List<SubCatagory> sub=subService.getAllSub();
		
		model.addAttribute("subCat" , new SubCatagory());
		model.addAttribute("subCata" ,  sub);
		
		return "admin/addsubcategory";
	}
	
	@PostMapping("/saveSubcatagory")
	public String saveCatagory(Model model , @Valid SubCatagory subCatagory , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "addSubcatagory";
		}
		subService.save(subCatagory);
	
	return "redirect:/addsubcategory";
	}
	
}
