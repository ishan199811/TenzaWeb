package com.tenzaWeb.product.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tenzaWeb.product.fileuploader.FileUploaderUtil;
import com.tenzaWeb.product.model.entity.Brand;
import com.tenzaWeb.product.model.entity.Catagory;
import com.tenzaWeb.product.model.entity.Image;
import com.tenzaWeb.product.model.entity.Product;
import com.tenzaWeb.product.repository.ImageRepository;
import com.tenzaWeb.product.repository.ProductRepository;





@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ImageRepository imageRepository;

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

	public void save(@Valid Product product, MultipartFile file1, MultipartFile file2,
			MultipartFile file3, MultipartFile file4, MultipartFile file5, Model model) throws IOException {
		
		Image img=new Image();
		
		
		
		String fileName1 = StringUtils.cleanPath(file1.getOriginalFilename());
		String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
		String fileName3 = StringUtils.cleanPath(file3.getOriginalFilename());
		String fileName4 = StringUtils.cleanPath(file4.getOriginalFilename());
		String fileName5 = StringUtils.cleanPath(file5.getOriginalFilename());
        img.setImageurl1("/website/img2/product/"+fileName1);
        img.setImageurl2("/website/img2/product/"+fileName2);
        img.setImageurl3("/website/img2/product/"+fileName3);
        img.setImageurl4("/website/img2/product/"+fileName4);
        img.setImageurl5("/website/img2/product/"+fileName5);
		
        imageRepository.save(img);
		
        product.setImageId(img);
		productRepository.save(product);
		
		String uploadDir = "target/classes/static/website/img2/product/" ;
        
        
        FileUploaderUtil.saveFile(uploadDir, fileName1, file1);
        FileUploaderUtil.saveFile(uploadDir, fileName2, file2);
        FileUploaderUtil.saveFile(uploadDir, fileName3, file3);
        FileUploaderUtil.saveFile(uploadDir, fileName4, file4);
        FileUploaderUtil.saveFile(uploadDir, fileName5, file5);
		
	}
	
	public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.productRepository.findAll(pageable);
	}

	 
		// TODO Auto-generated method stub
		
	

	
	}


