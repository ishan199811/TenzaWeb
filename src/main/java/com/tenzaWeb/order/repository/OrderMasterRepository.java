package com.tenzaWeb.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tenzaWeb.order.model.entity.OrderMaster;
import com.tenzaWeb.security.model.entity.User;





@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster,Long>{

	

	List<OrderMaster> findAllByUserOrderByCreatedDateDesc(User user);

	List<OrderMaster> findAllByUser(User user);



}
