package com.tenzaWeb.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenzaWeb.order.model.entity.DispatchedOrderMaster;




@Repository
public interface DispatchedOrderRepository extends JpaRepository<DispatchedOrderMaster,Long> {

}
