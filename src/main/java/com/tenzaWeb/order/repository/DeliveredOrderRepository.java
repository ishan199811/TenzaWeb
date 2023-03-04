package com.tenzaWeb.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenzaWeb.order.model.entity.DeliveredOrderMaster;




@Repository
public interface DeliveredOrderRepository extends JpaRepository<DeliveredOrderMaster,Long>{

}
