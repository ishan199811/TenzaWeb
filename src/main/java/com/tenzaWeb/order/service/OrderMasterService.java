package com.tenzaWeb.order.service;

import java.util.List;

import com.tenzaWeb.address.model.entity.Address;
import com.tenzaWeb.order.model.entity.OrderItems;
import com.tenzaWeb.order.model.entity.OrderMaster;
import com.tenzaWeb.user.model.User;

public interface OrderMasterService {
	
	List<OrderMaster> getOrderByUserId(User userId);

	long placeOrder(String userId , Address address);

	List<OrderItems> getOrderItemsByOrder(OrderMaster order);

	List<OrderMaster> getByUser(User user);

	List<OrderMaster> getAllOrders();



	List<OrderItems> getAllOrdersItems(OrderMaster order);


	
	/* String getOrder(Long orderId); */
	    
}
