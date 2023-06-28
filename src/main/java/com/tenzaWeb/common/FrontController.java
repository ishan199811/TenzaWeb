package com.tenzaWeb.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class FrontController {

	
	
	@RequestMapping("/log.html")
	public String viewLogPage() {
		return "log";
	}
	@RequestMapping("/log1.html")
	public String viewLogPage1() {
		return "UserDashBoard";
	}
	
	@RequestMapping("/f")
	public String viewLogPage2() {
		return "ContactUs";
	}
	@RequestMapping("/fu")
	public String viewLogPage22() {
		return "imchain";
	}
	
	@RequestMapping("/hello")
	public String viewdemoPage() {
		return "reg";
	}
	
	
	@RequestMapping("/produ")
	public String viewProductPage() {
		return "products";
	}
	
	@RequestMapping("/about.html")
	public String viewAboutPage() {
		return "about";
	}
	
	@RequestMapping("/contact.html")
	public String viewContactPage() {
		return "contact";
	}
	
	@RequestMapping("/productdetail")
	public String viewProductDetaiPage() {
		return "product-details";
	}
	
	@RequestMapping("/business-plan.html")
	public String viewPage() {
		return "business-plan";
	}
	
	@RequestMapping("/top-leaders.html")
	public String iewPage() {
		return "top-leaders";
	}
	
	@RequestMapping("/payment.html")
	public String vvviewPage() {
		return "payment.html";
	}
	
	@RequestMapping("/gallery.html")
	public String viewGallaryPage() {
		return "gallery.html";
	}
	
	@RequestMapping("/legal.html")
	public String viewlegalPage() {
		return "legal.html";
	}
	
	@RequestMapping("/franchise.html")
	public String viewlfranchiselPage() {
		return "franchise.html";
	}
	
			@RequestMapping("/product-details.html")
			public String viewldetailsPage() {
				return "product-details.html";
			}
			
			@RequestMapping("/loginpage")
			public String shoeloginpage() {
					return "login";
				}
			@RequestMapping("/adminpannel")
			public String shoeAdminpage() {
					return "admin/index";
				}



			@RequestMapping("/addsize-color-unit.html")
			public String shoeColorSizePage() {
					return "admin/addsize-color-unit";
				}
			
			@RequestMapping("/add category.html")
			public String shoeAddcatagory() {
					return "admin/add category.html";
				}

			@RequestMapping("/l")
			public String shoeAdd() {
					return "Register.html";
				}


}
