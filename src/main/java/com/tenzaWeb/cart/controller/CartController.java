package com.tenzaWeb.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenzaWeb.address.model.entity.Address;
import com.tenzaWeb.address.service.AdderessService;
import com.tenzaWeb.cart.model.CartMaster;
import com.tenzaWeb.cart.model.request.AddToCartDTO;
import com.tenzaWeb.cart.model.request.CartDTO;
import com.tenzaWeb.cart.model.request.CartItemDto;
import com.tenzaWeb.cart.service.CartService;

import com.tenzaWeb.product.model.entity.Product;
import com.tenzaWeb.product.service.CatagoryService;
import com.tenzaWeb.product.service.ProductService;
import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.service.SecurityService;
import com.tenzaWeb.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CartController {
	@Autowired
	CatagoryService catagoryService;
@Autowired
AdderessService addService;
	@Autowired
	private CartService service;

	@Autowired
	private ProductService productservice;

	@Autowired
	private UserService userservice;
	@Autowired
	private SecurityService securityService;

	// @PostMapping("/addtocart/{productId}")

	@RequestMapping(value = "/addtocart", method = RequestMethod.POST)
	public String addProduct(@RequestParam(name = "productId") long productId,@ModelAttribute AddToCartDTO dto , Model model) {
		
		String userId = securityService.findLoggedInUsername();
		if (userId == null) {

			return "login";
		}
		User user = userservice.findByUserId(userId);

		Product product = productservice.getProductByProductId(productId);
		CartMaster cart = new CartMaster();
		cart.setUserId(user);
		cart.setProduct(product);
		if(dto.getQuantity()==0)
		{
			cart.setQuantity(1);
		}
		else
		{
			cart.setQuantity(dto.getQuantity());
		}
		service.addToCart(cart);
		 model.addAttribute("addedToCart","Your Item Is Added To cart");
		

		return "redirect:/cart.html";
	}
	
	/*
	 * @RequestMapping("checkout.html") public String viewCheckoutPage(Model model)
	 * { model.addAttribute("ordr", new Order()); List<CartItemDto> cartItems =
	 * cartdto.getCartItems();
	 * log.info("cartItems...................................................." +
	 * cartItems); double totalCost = cartdto.getTotalCost();
	 * log.info("totalCost...................................................." +
	 * totalCost);
	 * 
	 * 
	 * return "checkout";
	 * 
	 * }
	 */
	/*
	 * @RequestMapping("/cart.html") public String viewCartPage() { return "cart"; }
	 */

	@RequestMapping("/cart.html")
	public String cartByUserId(Model model) {

		String userId = securityService.findLoggedInUsername();
	//	log.info("user...................................................." + userId);
		User user = userservice.findByUserId(userId);

		// List<CartMaster> carts = (List<CartMaster>) service.listCartItems(user);
		CartDTO cartdto = service.listCartItems(user);

		List<CartItemDto> cartItems = cartdto.getCartItems();
		//log.info("cartItems...................................................." + cartItems);
		double totalCost = cartdto.getTotalCost();
		//log.info("totalCost...................................................." + totalCost);
		
		List<Address> add=addService.findAddressByUserId(user);
		
		model.addAttribute("add", add);

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalCost", totalCost);

		return "cart.html";
	}
	
//	 @DeleteMapping("/delete/{cartItemId}")
//	    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
//	        authenticationService.authenticate(token);
//	        int userId = authenticationService.getUser(token).getId();
//	        cartService.deleteCartItem(itemID, userId);
//	        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
//	    }
	 @GetMapping("/delete/{cartItemId}")
	 public String deleteCartItem(@PathVariable("cartItemId") long itemID)
	 {
		// String username = securityService.findLoggedInUsername();
		// log.info("              delete cart");
		 service.deletebyCartItem(itemID);
		 
		 
		 
		return "redirect:/cart.html";
		 
	 }
}
