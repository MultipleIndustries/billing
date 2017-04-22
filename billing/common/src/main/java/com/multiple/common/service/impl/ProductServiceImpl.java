package com.multiple.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.model.ProductMaster;
import com.multiple.common.repository.ProductRepository;
import com.multiple.common.service.ProductService;

/**
 * Service implementation for City.
 * 
 * @author Waheed
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductMaster save(ProductMaster product) throws Exception {
		return productRepository.save(product);
	}

	@Override
	public void delete(ProductMaster product) {
		productRepository.delete(product);
	}

	@Override
	public ProductMaster restore(ProductMaster product) {
		return productRepository.save(product);
	}

	@Override
	public ProductMaster update(ProductMaster product) throws Exception {
		return productRepository.save(product);
	}

	@Override
	public ProductMaster findById(long productId) {
		return productRepository.findOne(productId);
	}

	@Override
	public List<ProductMaster> findAllProducts() {
		return productRepository.findAll();
	}
	
	
}
