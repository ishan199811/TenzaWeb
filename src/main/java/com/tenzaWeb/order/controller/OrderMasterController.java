package com.tenzaWeb.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.model.Order;
import com.tenzaWeb.address.model.entity.Address;
import com.tenzaWeb.address.service.AdderessService;
import com.tenzaWeb.cart.model.request.CartDTO;
import com.tenzaWeb.cart.model.request.CartItemDto;
import com.tenzaWeb.cart.service.CartService;
import com.tenzaWeb.order.model.entity.OrderItems;
import com.tenzaWeb.order.model.entity.OrderMaster;
import com.tenzaWeb.order.repository.OrderItemsRepository;
import com.tenzaWeb.order.service.OrderMasterService;
import com.tenzaWeb.product.model.entity.Brand;
import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.model.entity.Product;
import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.service.SecurityService;
import com.tenzaWeb.user.service.UserService;

import lombok.extern.slf4j.Slf4j;



@Controller
/*@RestController*/
/* @RequestMapping("/api/") */
@Slf4j
public class OrderMasterController {
	
	@Autowired
	private OrderMasterService orderMasterservice;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	OrderItemsRepository itemsRepository;
	
	
	@Autowired 
	UserService userService;
	
	@Autowired
	private CartService service;
	
	@Autowired
	AdderessService addressService;
	
	
	@GetMapping("/checkout")
	public String saveAddress( Model model , @Valid Address address , BindingResult bindingResult) {
		
		  if (bindingResult.hasErrors()) {       
	            return "address";
	 } 
		
				String userId = securityService.findLoggedInUsername();
		//.info("user...................................................." + userId);
		User user = userService.findByUserId(userId);
	
		long order = orderMasterservice.placeOrder(userId,address);
		model.addAttribute("userId" , userId );
		// List<CartMaster> carts = (List<CartMaster>) service.listCartItems(user);
		CartDTO cartdto = service.listCartItems(user);

		List<CartItemDto> cartItems = cartdto.getCartItems();
		//.info("cartItems...................................................." + cartItems);
		double totalCost = cartdto.getTotalCost();
		//.info("totalCost...................................................." + totalCost);
		model.addAttribute("address",  address);
		model.addAttribute("order",  order);
		model.addAttribute("ordr", new OrderMaster());
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalCost", totalCost);
		
		return "checkout";
		
		
	}

@GetMapping("/getorder")
public String getOrder(Model model) {
	String userId=securityService.findLoggedInUsername();
	User user=userService.findByUserId(userId);
	List<OrderMaster> order=orderMasterservice.getByUser(user);
	
 model.addAttribute("order", order);


	
	return "order"; 
	
	
}


@GetMapping("/proorder")
public String productByBrand(Model model ,@Param("orderId") OrderMaster orderId) {  
	  List<OrderItems> orderItems =orderMasterservice.getOrderItemsByOrder(orderId);
	
	
	  model.addAttribute("orderItems", orderItems);
		String userId = securityService.findLoggedInUsername();
		//.info("user...................................................." + userId);
		User user = userService.findByUserId(userId);

		// List<CartMaster> carts = (List<CartMaster>) service.listCartItems(user);
		CartDTO cartdto = service.listCartItems(user);

		List<CartItemDto> cartItems = cartdto.getCartItems();
		//.info("cartItems...................................................." + cartItems);
		double totalCost = cartdto.getTotalCost();
		//.info("totalCost...................................................." + totalCost);

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalCost", totalCost);

	  return "orderitems";
}
	
}
