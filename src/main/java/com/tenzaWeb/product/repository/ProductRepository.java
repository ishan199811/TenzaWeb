package com.tenzaWeb.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tenzaWeb.product.model.entity.Brand;
import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.model.entity.Product;
import com.tenzaWeb.product.model.entity.SubCatagory;

public interface ProductRepository extends JpaRepository<Product,Long>{
	Product save(Product product);

	
	Product findByproductId(long productId);

	@Query("SELECT s FROM Product s WHERE CONCAT(s.productName ,s.brandId.brandName) LIKE %?1%")
	List<Product> search(String keyword);

List<Product> findProductByBrandId(Brand brandId);

List<Product> findProductByCatagoryId(Catagory catagoryId);


List<Product> findBrandByproductId(long id);



}
