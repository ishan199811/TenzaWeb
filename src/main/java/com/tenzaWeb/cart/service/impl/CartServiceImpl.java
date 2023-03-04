package com.tenzaWeb.cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenzaWeb.cart.model.CartMaster;
import com.tenzaWeb.cart.model.request.CartDTO;
import com.tenzaWeb.cart.model.request.CartItemDto;
import com.tenzaWeb.cart.repository.CartRepositry;
import com.tenzaWeb.cart.service.CartService;
import com.tenzaWeb.user.model.User;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepositry cartrepo;
	


	@Override
	public void addToCart(CartMaster cart) {
		//cart.setQuantity(1);
		cart.setTotal(cart.getQuantity() * cart.getProduct().getProductPrice());
		cartrepo.save(cart);

	}

	@Override
	public void deleteAllCartitm(User userId) {
		
      cartrepo.deleteByUserId(userId);		
	}

	private CartItemDto getDtoFromCart(CartMaster cart) {
		
		return new CartItemDto(cart);
	}

	@Override
	public void deletebyCartItem(long cartId) {
		
		cartrepo.deleteById(cartId);
		
		
	}

	

	@Override
	public CartDTO listCartItems(User userId) {
		List<CartMaster> cartList = cartrepo.findAllByUserId(userId);
		//log.info("cart list.........................");

		List<CartItemDto> cartItems = new ArrayList<>();
		for (CartMaster cart : cartList) {
			CartItemDto cartItemDto = getDtoFromCart(cart);
			cartItems.add(cartItemDto);
		}
		double totalCost = 0;
		//long total = 0;
		for (CartItemDto cartItemDto : cartItems) {
		//	log.info("                                 trerer  "+cartItemDto.getProductQuatity());
		//	log.info("                                 trerer  "+cartItemDto.getProduct().getProductPrice());
			double total=cartItemDto.getProduct().getProductPrice() * cartItemDto.getProductQuatity();
		//	log.info("                              "+total);
			totalCost = totalCost+total;
		}
		 return new CartDTO(cartItems,totalCost);
	}

	@Override
	public String deleteUserCartItems(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public void deleteUserCartItems(User user) { // TODO Auto-generated
	 * method stub cartrepo.deleteByEmployee(user); }
	 * 
	 */	

}
