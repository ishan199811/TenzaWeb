package com.tenzaWeb.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.order.model.entity.OrderItems;
import com.tenzaWeb.order.model.entity.OrderMaster;



public interface OrderItemsRepository extends JpaRepository<OrderItems,Long> {

	List<OrderItems> getByOrder(OrderMaster order);

	
	
}
