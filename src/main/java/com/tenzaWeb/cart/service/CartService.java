package com.tenzaWeb.cart.service;

import com.tenzaWeb.cart.model.CartMaster;
import com.tenzaWeb.cart.model.request.CartDTO;
import com.tenzaWeb.security.model.entity.User;


public interface CartService {
	

	public void addToCart(CartMaster cart);
	
	//public void addToCart(AddToCartDTO addtocartdto);



	public void deleteAllCartitm(User user);




	 public CartDTO listCartItems(User user);
	 
	 public void deletebyCartItem(long cartId);

	public String deleteUserCartItems(User user);

	CartDTO listCartItems1(User userId);

	String deleteUserCartItems1(User user);



}
