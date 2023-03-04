package com.tenzaWeb.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.model.entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement,Long> {

}
