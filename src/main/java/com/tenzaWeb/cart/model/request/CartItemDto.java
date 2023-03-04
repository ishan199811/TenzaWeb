package com.tenzaWeb.cart.model.request;


import com.sun.istack.NotNull;
import com.tenzaWeb.cart.model.CartMaster;
import com.tenzaWeb.product.model.entity.Product;

import lombok.Data;



public class CartItemDto {
	  private long id;
	    private @NotNull long productQuatity;
	    private @NotNull Product product;
	    private @NotNull double total;
		public CartItemDto(CartMaster cart) {
			// TODO Auto-generated constructor stub
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getProductQuatity() {
			return productQuatity;
		}
		public void setProductQuatity(long productQuatity) {
			this.productQuatity = productQuatity;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
	    

	   
		
}
