package com.tenzaWeb.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.product.model.entity.Catagory;

public interface CatagoryRepository extends JpaRepository<Catagory,Long> {

}
