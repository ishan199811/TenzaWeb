package com.tenzaWeb.admin.product.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tenzaWeb.product.fileuploader.FileUploaderUtil;
import com.tenzaWeb.product.model.entity.Brand;
import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.model.entity.Measurement;
import com.tenzaWeb.product.model.entity.Product;
import com.tenzaWeb.product.model.entity.SubCatagory;
import com.tenzaWeb.product.service.BrandService;
import com.tenzaWeb.product.service.CatagoryService;
import com.tenzaWeb.product.service.MeasurementService;
import com.tenzaWeb.product.service.ProductService;
import com.tenzaWeb.product.service.SubCatagoryService;
import com.tenzaWeb.user.service.UserService;

@Controller
//@RequestMapping("/admin")
public class AProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BrandService brandService;

	@Autowired
	UserService userService;
	
	@Autowired
	CatagoryService catagoryService;
	
	@Autowired
	SubCatagoryService subCatagoryService;
	
	@Autowired
	MeasurementService measureService;
	
	@RequestMapping("/og")
	public String showAdminPage() {
		
		return "admin/index";
	}
	
	
	@RequestMapping(value = "/addproduct.html", method = RequestMethod.GET)
    public String initView(Model model) {
		
		List<Product> product=productService.getAllProduct();
		 List<Brand> brand =brandService.getAllBrand();
		  List<Catagory> catagory =catagoryService.getAllCatagory();
		  List<SubCatagory> subcatagory =subCatagoryService.getAllSub();
		  List<Measurement> measurement =measureService.getAllMeasurement();
		  model.addAttribute("subcatagory", subcatagory);
		  model.addAttribute("measurement", measurement);
		model.addAttribute("catagory", catagory);
		  model.addAttribute("brand", brand);
               model.addAttribute("product", new Product());
               model.addAttribute("product1", product);
        return "admin/addproduct";
	}	
	
	
	/* @PreAuthorize("hasRole('USER')") */
	@PostMapping("/saveP")
	public String submitForm(@Valid @ModelAttribute("product") Product product,Model model,@RequestParam("image1") MultipartFile multipartFile1,@RequestParam("image2") MultipartFile multipartFile2,@RequestParam("image3") MultipartFile multipartFile3,@RequestParam("image4") MultipartFile multipartFile4,@RequestParam("image5") MultipartFile multipartFile5,
	    BindingResult bindingResult) throws IOException {
	    System.out.println(product);
	     if (bindingResult.hasErrors()) {       
	            return "admin/addproduct";
	 } 
	    else {
	       	 
	         productService.save(product,multipartFile1 ,multipartFile2,multipartFile3,multipartFile4,multipartFile5,model);
	    	
	    }
	      return "redirect:/addproduct.html";
	}
}
