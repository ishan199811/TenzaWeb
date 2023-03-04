package com.tenzaWeb.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tenzaWeb.product.model.entity.Brand;
import com.tenzaWeb.product.model.entity.Product;
import com.tenzaWeb.product.service.BrandService;

@Controller
public class BrandController {
@Autowired
BrandService brandService;


@GetMapping("/pr")
public String topicList(Model model)
{
	  List<Brand> brand = brandService.getAllBrand();
	 model.addAttribute("brand", brand);
    System.out.println(brand);

	return "products";
	}
}
