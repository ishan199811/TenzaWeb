package com.tenzaWeb.admin.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.model.entity.Measurement;
import com.tenzaWeb.product.service.MeasurementService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
/* @RestController */
public class AMeasurementController {

	@Autowired
	MeasurementService measureService;
	
	
	@RequestMapping("/addMeasurement")
	public String showCatagoryPage(Model model) {
		
		List<Measurement> measure=measureService.getAllMeasurement();
		model.addAttribute("measure", new Measurement());
		model.addAttribute("measurement" , measure);
		return "admin/addMeasurement";
		
	}
	@PostMapping("/savemeasurement")
	public String saveCatagory(Model model , @Valid Measurement measurement , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "addMeasurement";
		}
		measureService.save(measurement);
	
	return "redirect:/addMeasurement";
	}
}
	
	
	






