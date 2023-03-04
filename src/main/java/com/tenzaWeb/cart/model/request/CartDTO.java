package com.tenzaWeb.cart.model.request;

import java.util.List;

import lombok.Data;
@Data
public class CartDTO {
	
	 private List<CartItemDto> cartItems;
	    private double totalCost;

	    public CartDTO(List<CartItemDto> cartItemDtoList, double totalCost) {
	        this.cartItems = cartItemDtoList;
	        this.totalCost = totalCost;
	    }

		public List<CartItemDto> getCartItems() {
			return cartItems;
		}

		public void setCartItems(List<CartItemDto> cartItems) {
			this.cartItems = cartItems;
		}

		public double getTotalCost() {
			return totalCost;
		}

		public void setTotalCost(double totalCost) {
			this.totalCost = totalCost;
		}

	

}
