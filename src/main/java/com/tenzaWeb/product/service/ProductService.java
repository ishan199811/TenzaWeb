package com.tenzaWeb.product.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tenzaWeb.product.model.entity.Brand;
import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.model.entity.Product;
import com.tenzaWeb.product.repository.ProductRepository;





@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	public List<Product> getProductByBrand(Brand brandId){
		return productRepository.findProductByBrandId(brandId);
	}
	
	public List<Product> getProductByCatagory(Catagory catagoryId){
		return productRepository.findProductByCatagoryId(catagoryId);
	}
	
	

	public List<Product> listAll(String keyword) {
		if (keyword != null) {
	        return productRepository.search(keyword);
	    }
	    return productRepository.findAll();
	}

	public Product getProductByProductId(Long productId) {
		return productRepository.getById(productId);
	}

	public void save(@Valid Product product) {
		productRepository.save(product);
		
	}
	
	public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.productRepository.findAll(pageable);
	}

	
	}


