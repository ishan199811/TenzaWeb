package com.tenzaWeb.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.product.model.entity.Brand;



public interface BrandRepository extends JpaRepository<Brand ,Long> {

	Brand findByBrandId(long id);

}
