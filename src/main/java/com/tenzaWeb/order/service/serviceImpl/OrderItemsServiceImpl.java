package com.tenzaWeb.order.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenzaWeb.order.model.entity.OrderItems;
import com.tenzaWeb.order.repository.OrderItemsRepository;
import com.tenzaWeb.order.service.OrderItemsService;



@Service
public class OrderItemsServiceImpl implements OrderItemsService{
	
@Autowired
OrderItemsRepository orderItemsRepository;
	
	
	 public String addOrderedProducts(OrderItems orderItem) {
	        orderItemsRepository.save(orderItem);
	        
	        return "orderItem";
	    }

}
