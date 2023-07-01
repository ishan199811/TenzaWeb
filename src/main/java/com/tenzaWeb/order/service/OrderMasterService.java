package com.tenzaWeb.order.service;

import java.util.List;


import com.tenzaWeb.order.model.entity.OrderItems;
import com.tenzaWeb.order.model.entity.OrderMaster;
import com.tenzaWeb.security.model.entity.User;


public interface OrderMasterService {
	
	List<OrderMaster> getOrderByUserId(User userId);

//	long placeOrder(String userId , Address address);

	List<OrderItems> getOrderItemsByOrder(OrderMaster order);

	List<OrderMaster> getByUser(User user);

	List<OrderMaster> getAllOrders();



	List<OrderItems> getAllOrdersItems(OrderMaster order);

	List<OrderMaster> getByUser1(User user);


	
	/* String getOrder(Long orderId); */
	    
}
