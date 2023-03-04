package com.tenzaWeb.product.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tenzaWeb.cart.model.request.CartDTO;
import com.tenzaWeb.cart.model.request.CartItemDto;
import com.tenzaWeb.cart.service.CartService;
import com.tenzaWeb.product.fileuploader.FileUploaderUtil;
import com.tenzaWeb.product.model.entity.Brand;
import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.model.entity.Product;
import com.tenzaWeb.product.service.BrandService;
import com.tenzaWeb.product.service.CatagoryService;
import com.tenzaWeb.product.service.ProductService;
import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.service.SecurityService;
import com.tenzaWeb.user.service.UserService;

import lombok.extern.slf4j.Slf4j;




@Controller

@Slf4j
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BrandService brandService;

	@Autowired
	UserService userService;
	
	@Autowired
	CatagoryService catagoryService;
	
	@Autowired
	SecurityService sc;
	
	@Autowired
	private CartService service;

	@Autowired 
	SecurityService securityService;
	
	@RequestMapping("/")
	public String vviewHome(Model model)
	
	{
		
		
		List<Product> product = productService.getAllProduct();
		model.addAttribute("product", product);
		String userId = securityService.findLoggedInUsername();
	//	log.info("user...................................................." + userId);
		User user = userService.findByUserId(userId);

		// List<CartMaster> carts = (List<CartMaster>) service.listCartItems(user);
		CartDTO cartdto = service.listCartItems(user);

		List<CartItemDto> cartItems = cartdto.getCartItems();
	//	log.info("cartItems...................................................." + cartItems);
		double totalCost = cartdto.getTotalCost();
	//	log.info("totalCost...................................................." + totalCost);

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalCost", totalCost);

		return "index";
	}
	
	@RequestMapping("/Default.html")
	public String viewHome(Model model)
	{
		
		
		List<Product> product = productService.getAllProduct();
		model.addAttribute("product", product);
		String userId = securityService.findLoggedInUsername();
		//log.info("user...................................................." + userId);
		User user = userService.findByUserId(userId);

		// List<CartMaster> carts = (List<CartMaster>) service.listCartItems(user);
		CartDTO cartdto = service.listCartItems(user);

		List<CartItemDto> cartItems = cartdto.getCartItems();
		//log.info("cartItems...................................................." + cartItems);
		double totalCost = cartdto.getTotalCost();
		//log.info("totalCost...................................................." + totalCost);

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalCost", totalCost);

		return "index";
	}
	
	
	@GetMapping("/products.html")
	public String productList(Model model)
	{
		String userId = securityService.findLoggedInUsername();
		//log.info("user...................................................." + userId);
		User user = userService.findByUserId(userId);

		// List<CartMaster> carts = (List<CartMaster>) service.listCartItems(user);
		CartDTO cartdto = service.listCartItems(user);

		List<CartItemDto> cartItems = cartdto.getCartItems();
		//log.info("cartItems...................................................." + cartItems);
		double totalCost = cartdto.getTotalCost();
		//log.info("totalCost...................................................." + totalCost);

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalCost", totalCost);

       
    	return findPaginated(1, "productId", "asc", model);
		}
	
	
	@GetMapping("/pro")
	public String productByBrand(Model model ,@Param("brandId") Brand brandId) {  
		  List<Brand> brand =brandService.getAllBrand();
		  List<Catagory> catagory =catagoryService.getAllCatagory();
		List<Product> product = productService.getProductByBrand(brandId);
		model.addAttribute("catagory", catagory);
		  model.addAttribute("brand", brand);
		  model.addAttribute("brand1", brand);
		  model.addAttribute("product", product);
			String userId = securityService.findLoggedInUsername();
		//	log.info("user...................................................." + userId);
			User user = userService.findByUserId(userId);

			// List<CartMaster> carts = (List<CartMaster>) service.listCartItems(user);
			CartDTO cartdto = service.listCartItems(user);

			List<CartItemDto> cartItems = cartdto.getCartItems();
		//	log.info("cartItems...................................................." + cartItems);
			double totalCost = cartdto.getTotalCost();
		//	log.info("totalCost...................................................." + totalCost);

			model.addAttribute("cartItems", cartItems);
			model.addAttribute("totalCost", totalCost);

		  return "products";
	}
	
	
	@GetMapping("/product-details.html")
	public String productByProductId(Model model ,@Param("productId") Long productId) {  
			  List<Product> product1 = productService.getAllProduct();  
		Product product = productService.getProductByProductId(productId);
		model.addAttribute("product1", product1);
		  model.addAttribute("product", product);
			String userId = securityService.findLoggedInUsername();
		//	log.info("user...................................................." + userId);
			User user = userService.findByUserId(userId);

			// List<CartMaster> carts = (List<CartMaster>) service.listCartItems(user);
			CartDTO cartdto = service.listCartItems(user);

			List<CartItemDto> cartItems = cartdto.getCartItems();
		//	log.info("cartItems...................................................." + cartItems);
			double totalCost = cartdto.getTotalCost();
		//	log.info("totalCost...................................................." + totalCost);

			model.addAttribute("cartItems", cartItems);
			model.addAttribute("totalCost", totalCost);

		return "product-details.html";
	}
	
	
	@GetMapping("/prr")
	public String productByCatagory(Model model ,@Param("catagoryId") Catagory catagoryId) {  
		 List<Brand> brand =brandService.getAllBrand();
		  List<Catagory> catagory =catagoryService.getAllCatagory();
		List<Product> product = productService.getProductByCatagory(catagoryId);
		model.addAttribute("catagory", catagory);
		  model.addAttribute("brand", brand);
		    model.addAttribute("product", product);
			String userId = securityService.findLoggedInUsername();
		//	log.info("user...................................................." + userId);
			User user = userService.findByUserId(userId);

			// List<CartMaster> carts = (List<CartMaster>) service.listCartItems(user);
			CartDTO cartdto = service.listCartItems(user);

			List<CartItemDto> cartItems = cartdto.getCartItems();
			//log.info("cartItems...................................................." + cartItems);
			double totalCost = cartdto.getTotalCost();
			//log.info("totalCost...................................................." + totalCost);

			model.addAttribute("cartItems", cartItems);
			model.addAttribute("totalCost", totalCost);

		    return "products";
	}
	
	@RequestMapping("/searchs")
	public String viewHomePage(Model model, @Param("keyword")  String keyword) {
	  System.out.println("..............................................");
		  List<Brand> brand =brandService.getAllBrand();
	  List<Catagory> catagory =catagoryService.getAllCatagory();
	List<Product> product = productService.listAll(keyword);
	model.addAttribute("catagory", catagory);
	  model.addAttribute("brand", brand);
	  model.addAttribute("product", product);
	  model.addAttribute("keyword", keyword);
		String userId = securityService.findLoggedInUsername();
	//	log.info("user...................................................." + userId);
		User user = userService.findByUserId(userId);

		// List<CartMaster> carts = (List<CartMaster>) service.listCartItems(user);
		CartDTO cartdto = service.listCartItems(user);

		List<CartItemDto> cartItems = cartdto.getCartItems();
	//	log.info("cartItems...................................................." + cartItems);
		double totalCost = cartdto.getTotalCost();
	//	log.info("totalCost...................................................." + totalCost);

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalCost", totalCost);

	  return "products";
}
	
	
	
	
	
	@GetMapping("/page{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 10;
		
		Page<Product> page = productService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Product> listProduct = page.getContent();
		  List<Product> product =productService.getAllProduct();
		  List<Brand> brand =brandService.getAllBrand();
		  List<Catagory> catagory =catagoryService.getAllCatagory();
		  model.addAttribute("catagory", catagory);
		  model.addAttribute("brand", brand);
		 
	
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("product", listProduct);
		return "products";
	}
	
	
}
